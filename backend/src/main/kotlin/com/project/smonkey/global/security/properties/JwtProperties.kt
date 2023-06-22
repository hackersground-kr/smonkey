package com.project.smonkey.global.security.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

/**
 * JWT의 속성을 가지고 있는 [JwtProperties]
 *
 * @param secretKey secretKey of jtw
 * @param accessTokenExp accessToken Expired time
 * @param refreshTokenExp refreshToken Expired time
 */

@ConfigurationProperties(prefix = "jwt")
@ConstructorBinding
class JwtProperties(
    val secretKey: String,
    val accessTokenExp: Long,
    val refreshTokenExp: Long,
) {

    companion object {
        const val TOKEN_PREFIX = "Bearer "
        const val TOKEN_HEADER_NAME = "Authorization"
        const val ACCESS_VALUE = "access"
        const val REFRESH_VALUE = "refresh"
    }
}
