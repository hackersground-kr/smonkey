package com.saehyun.presentation.feature.home

sealed class HomeSideEffect {
    data class SendMessage(val message: String): HomeSideEffect()
}
