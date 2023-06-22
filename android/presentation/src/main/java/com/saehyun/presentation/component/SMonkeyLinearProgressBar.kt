package com.saehyun.presentation.component

import androidx.compose.foundation.layout.height
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.style.SMonkeyColor

@Composable
fun SMonkeyLinearProgressBar(
    progress: Float,
) {
    LinearProgressIndicator(
        modifier = Modifier.height(8.dp),
        color = SMonkeyColor.Main1,
        progress = progress,
    )
}