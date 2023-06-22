package com.saehyun.presentation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.R
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.util.smonkeyClickable

@Composable
fun SMonkeyCheckBox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
) {
    val backgroundColor =
        animateColorAsState(
            targetValue = if (isChecked) SMonkeyColor.Main1 else SMonkeyColor.Gray300,
            label = "",
        )

    Box(
        modifier = Modifier
            .size(16.dp)
            .background(
                color = backgroundColor.value,
                shape = CircleShape,
            )
            .smonkeyClickable(
                rippleEnabled = false
            ) {
                onCheckedChange(!isChecked)
            },
        contentAlignment = Alignment.Center,
    ) {
        if (isChecked) {
            Image(
                painter = painterResource(id = R.drawable.ic_check_12),
                contentDescription = null,
            )
        }
    }
}