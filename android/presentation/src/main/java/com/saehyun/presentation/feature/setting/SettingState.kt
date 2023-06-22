package com.saehyun.presentation.feature.setting

import com.saehyun.presentation.feature.home.SMonkeyUser

data class SettingState(
    val smonkey: SMonkeyUser = SMonkeyUser.empty(),
    val username: String = "",
)
