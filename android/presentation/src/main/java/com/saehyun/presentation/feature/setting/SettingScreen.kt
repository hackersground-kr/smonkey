package com.saehyun.presentation.feature.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.component.BigTopAppBar
import com.saehyun.presentation.component.SMonkeyLayout
import com.saehyun.presentation.component.SMonkeySimpleLayout
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody1
import com.saehyun.presentation.style.SmonkeyBody6

@Composable
fun SettingScreen(
    vm: SettingViewModel,
) {
    val state = vm.container.stateFlow.collectAsState().value

    SMonkeySimpleLayout(
        topAppBar = {
            BigTopAppBar(
                leadingContent = { SmonkeyBody1(text = "설정") },
                trailingContent = {
                    SmonkeyBody6(
                        text = "수정",
                        color = SMonkeyColor.Main1
                    )
                },
            )
        },
        content = {
            Spacer(space = 16.dp)
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                SMonkeyLayout(
                    username = state.username,
                    level = state.smonkey.level,
                    smonkeyName = state.smonkey.smonkeyName,
                    nextPoint = state.smonkey.nextPoint,
                    point = state.smonkey.point,
                    percentage = state.smonkey.percentage,
                )
            }
        },
    )
}