package com.project.smonkey.domain.user.service

import com.project.smonkey.domain.smonkey.entity.SMonkey
import com.project.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.project.smonkey.domain.smonkey.utils.DefaultPoint
import com.project.smonkey.domain.user.entity.RefreshToken
import com.project.smonkey.domain.user.entity.User
import com.project.smonkey.domain.user.exception.UserAlreadyExistException
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.domain.user.payload.request.SignUpRequest
import com.project.smonkey.domain.user.repository.RefreshTokenRepository
import com.project.smonkey.domain.user.repository.UserRepository
import com.project.smonkey.global.payload.BaseResponse
import com.project.smonkey.global.security.jwt.JwtTokenProvider
import com.project.smonkey.global.security.jwt.payload.TokenResponse
import com.project.smonkey.global.security.properties.JwtProperties
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

private const val SIGN_UP_MESSAGE = "sign up success"

@Service
class SignUpService(
    private val sMonkeyFacade: SMonkeyFacade,
    private val userRepository: UserRepository,
    private val refreshTokenRepository: RefreshTokenRepository,
    private val jwtTokenProvider: JwtTokenProvider,
    private val passwordEncoder: PasswordEncoder,
    private val userFacade: UserFacade,
    jwtProperties: JwtProperties,
) {
    private val refreshExp: Long = jwtProperties.refreshTokenExp

    fun signUp(request: SignUpRequest): BaseResponse<TokenResponse> {
        if (userFacade.getUserExist(request.accountId)) throw UserAlreadyExistException

        var user = User(
            accountId = request.accountId,
            password = passwordEncoder.encode(request.password),
            name = request.name,
            email = request.email,
            age = request.age,
            amount = request.amount,
            price = request.price,
            smokingDate = request.smokingDate,
            noSmokingDate = request.noSmokingDate,
            reason = request.reason,
            cigaretteAmount = request.cigaretteAmount
        )

        user = userRepository.save(user)

        sMonkeyFacade.saveSMonkey(
            SMonkey(
                userId = user.id,
                name = request.sMonkeyName,
                backgroundColor = request.backgroundColor,
                point = DefaultPoint,
                savePrice = 0,
                spendPrice = 0,
                noSmokingDate = 0,
                smokingDate = 0,
            )
        )

        val tokenResponse = jwtTokenProvider.getToken(
            accountId = user.accountId,
        )

        val refreshToken = RefreshToken(
            accountId = request.accountId,
            token = tokenResponse.refreshToken,
            ttl = refreshExp,
        )

        refreshTokenRepository.save(refreshToken)

        return BaseResponse(
            status = 201,
            message = SIGN_UP_MESSAGE,
            content = tokenResponse,
        )
    }
}
