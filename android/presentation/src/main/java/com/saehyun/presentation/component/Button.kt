package com.saehyun.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saehyun.common_kotlin.runIf
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody5
import com.saehyun.presentation.style.SmonkeyBody6
import com.saehyun.presentation.util.smonkeyClickable

@Composable
fun SMonkeyMediumButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    color: Color,
    onClick: () -> Unit,
) {
    val textColor = if (enabled) SMonkeyColor.White else color

    Box(
        modifier = modifier
            .width(136.dp)
            .height(40.dp)
            .smonkeyClickable(
                rippleEnabled = enabled,
            ) {
                if (enabled) {
                    onClick()
                }
            }
            .runIf(!enabled) {
                border(
                    width = 1.dp,
                    color = color,
                    shape = RoundedCornerShape(12.dp),
                )
            }
            .runIf(enabled) {
                background(
                    color = color,
                    shape = RoundedCornerShape(12.dp),
                )
            },
        contentAlignment = Alignment.Center,
    ) {
        SmonkeyBody6(
            text = text,
            color = textColor,
        )
    }
}

@Composable
fun SmonkeyTextFieldButton(
    modifier: Modifier = Modifier,
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
) {
    val backgroundColor = if (enabled) SMonkeyColor.Gray200 else SMonkeyColor.Gray200

    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
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
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Spacer(space = 12.dp)
        SmonkeyBody6(
            text = text,
            color = SMonkeyColor.Black,
        )
    }
}

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

@Composable
fun SMonkeyOutlineLargeButton(
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
            .border(
                shape = RoundedCornerShape(12.dp),
                color = backgroundColor,
                width = 1.dp
            ),
        contentAlignment = Alignment.Center,
    ) {
        SmonkeyBody5(
            text = text,
            color = backgroundColor,
        )
    }
}