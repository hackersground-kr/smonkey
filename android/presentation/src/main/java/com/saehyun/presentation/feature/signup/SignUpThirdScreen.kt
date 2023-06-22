package com.saehyun.presentation.feature.signup

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.component.Spacer

@Composable
fun SignUpThirdScreen(
    modifier: Modifier = Modifier,
    selectedReason: SmokingCessationReason,
    onReasonChanged: (SmokingCessationReason) -> Unit,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
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
            items(SmokingCessationReason.values()) { item ->
                SignUpCheckBox(
                    visible = selectedReason == item,
                    reason = item,
                    onClick = {
                       onReasonChanged(item)
                    },
                )
            }
        }
    }
}