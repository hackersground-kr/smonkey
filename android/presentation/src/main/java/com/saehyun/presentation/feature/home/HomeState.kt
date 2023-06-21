package com.saehyun.presentation.feature.home

data class HomeState(
    val isLoading: Boolean = false,
    val selectedIndex: Int = 0,
)