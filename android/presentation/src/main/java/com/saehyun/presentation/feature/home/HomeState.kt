package com.saehyun.presentation.feature.home

data class HomeState(
    val isLoading: Boolean = false,
    val selectedIndex: Int = 0,
    val smonkey: SMonkeyUser = SMonkeyUser.empty(),
    val username: String = "",

    // 금연 관련 정보
    val quitSmokingDate: String = "",
    val smokingDate: String = "",
    val savePrice: Int = 0,
    val spendPrice: Int = 0,
)

data class SMonkeyUser(
    val backgroundColor: String,
    val level: Int,
    val nextPoint: Int,
    val point: Int,
    val smonkeyName: String,
    val step: Int,
    val percentage: Float,
) {
    companion object {
        fun empty() = SMonkeyUser(
            backgroundColor = "",
            level = 0,
            nextPoint = 0,
            point = 0,
            smonkeyName = "",
            step = 0,
            percentage = 0f,
        )
    }
}