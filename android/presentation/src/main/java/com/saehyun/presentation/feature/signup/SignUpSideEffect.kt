package com.saehyun.presentation.feature.signup

sealed class SignUpSideEffect {
    object NavigateBack : SignUpSideEffect()
}
