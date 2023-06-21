package com.saehyun.presentation.feature.login

data class SignInState(
    val isLoading: Boolean = false,
    val id: String = "",
    val password: String = "",
)
