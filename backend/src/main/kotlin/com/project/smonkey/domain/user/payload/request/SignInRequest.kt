package com.project.smonkey.domain.user.payload.request

data class SignInRequest(
    val accountId: String,
    val password: String,
)
