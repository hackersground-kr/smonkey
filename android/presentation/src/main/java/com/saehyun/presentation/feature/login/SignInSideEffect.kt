package com.saehyun.presentation.feature.login

sealed class SignInSideEffect {
    object NavigateToHome : SignInSideEffect()
    data class SendMessage(val message: String) : SignInSideEffect()
}
