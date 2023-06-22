package com.project.smonkey.global.security.jwt.payload

/**
 * 일반적인 형태의 Token의 Response
 *
 * @param accessToken jwt accessToken
 * @param refreshToken jwt refreshToken
 */
data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
)
