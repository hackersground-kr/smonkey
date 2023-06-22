package com.saehyun.presentation.feature.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.component.SMonkeyCheckBox
import com.saehyun.presentation.component.SMonkeyTextField
import com.saehyun.presentation.component.Spacer
import okhttp3.internal.immutableListOf

@Composable
fun SignUpThirdScreen(
    modifier: Modifier = Modifier,
    state: SignUpState,
    vm: SignUpViewModel,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
    val selectIndex = remember { mutableStateOf(SmokingCessationReason.FAMILY_LOVED_ONES) }
    BaseSignUpScreen(
        modifier = modifier,
        index = 3,
        maxIndex = 3,
        title = "마지막!\n왜 금연을 시작하셨나요?",
        onPrevious = onPrevious,
        onNext = onNext,
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                Spacer(space = 30.dp)
            }
            items(SmokingCessationReason.values()) { reason ->
                SignUpCheckBox(
                    visible = selectIndex.value == reason,
                    reason = reason,
                    onClick = {
                        selectIndex.value = reason
                    },
                )
            }
        }
    }
}