package com.saehyun.presentation.feature.signup

sealed class SignUpSideEffect {
    object NavigateBack : SignUpSideEffect()

    object NavigateToHome: SignUpSideEffect()

    data class SendMessage(val message: String): SignUpSideEffect()
}
