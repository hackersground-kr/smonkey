package com.saehyun.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody5
import com.saehyun.presentation.util.smonkeyClickable

@Composable
fun SMonkeyLargeButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor = if (enabled) SMonkeyColor.Main1 else SMonkeyColor.Main3

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp)
            .smonkeyClickable(
                rippleEnabled = enabled,
            ) {
                if (enabled) {
                    onClick()
                }
            }
            .background(
                shape = RoundedCornerShape(12.dp),
                color = backgroundColor,
            ),
        contentAlignment = Alignment.Center,
    ) {
        SmonkeyBody5(
            text = text,
            color = SMonkeyColor.White,
        )
    }
}