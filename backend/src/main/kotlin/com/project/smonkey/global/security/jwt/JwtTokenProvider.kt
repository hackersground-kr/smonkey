package com.project.smonkey.global.security.jwt

import com.project.smonkey.global.security.auth.AuthDetailsService
import com.project.smonkey.global.security.exception.TokenExpiredException
import com.project.smonkey.global.security.exception.TokenSignatureException
import com.project.smonkey.global.security.exception.TokenUnExpectedException
import com.project.smonkey.global.security.exception.TokenValidateException
import com.project.smonkey.global.security.jwt.payload.AccessTokenResponse
import com.project.smonkey.global.security.jwt.payload.TokenResponse
import com.project.smonkey.global.security.properties.JwtProperties
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

/**
 * JWT Token의 generate를 담당하는 [JwtTokenProvider]
 */
@Component
class JwtTokenProvider(
    private val authDetailsService: AuthDetailsService,
    private val jwtProperty: JwtProperties,
) {

    fun authenticateUser(token: String): Authentication {
        val claims = getClaims(token)
        val id = claims.subject
        val authDetails = authDetailsService.loadUserByUsername(id.toString())
        return UsernamePasswordAuthenticationToken(authDetails, "", authDetails.authorities)
    }

    fun getToken(accountId: String): TokenResponse {
        val accessToken = generateToken(accountId, jwtProperty.accessTokenExp, JwtProperties.ACCESS_VALUE)
        val refreshToken = generateToken(accountId, jwtProperty.refreshTokenExp, JwtProperties.REFRESH_VALUE)
        return TokenResponse(
            accessToken = accessToken,
            refreshToken = refreshToken,
        )
    }

    fun getAccessToken(accountId: String): AccessTokenResponse {
        val accessToken = generateToken(accountId, jwtProperty.accessTokenExp, JwtProperties.ACCESS_VALUE)
        return AccessTokenResponse(accessToken)
    }

    private fun generateToken(accountId: String, expiration: Long, type: String): String {
        return JwtProperties.TOKEN_PREFIX + Jwts.builder()
            .setSubject(accountId)
            .setIssuedAt(Date())
            .signWith(SignatureAlgorithm.HS512, jwtProperty.secretKey)
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
            .setHeaderParam("typ", type)
            .compact()
    }

    fun getTokenFromHeader(httpServletRequest: HttpServletRequest): String? =
        httpServletRequest.getHeader(JwtProperties.TOKEN_HEADER_NAME)

    fun parseToken(token: String): String {
        if (token.startsWith(JwtProperties.TOKEN_PREFIX)) {
            return token.replace(JwtProperties.TOKEN_PREFIX, "")
        }
        throw TokenValidateException.EXCEPTION
    }

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperty.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is TokenExpiredException -> throw TokenExpiredException.EXCEPTION
                is TokenSignatureException -> throw TokenSignatureException.EXCEPTION
                is TokenValidateException -> throw TokenValidateException.EXCEPTION
                else -> throw TokenUnExpectedException.EXCEPTION
            }
        }
    }
}
