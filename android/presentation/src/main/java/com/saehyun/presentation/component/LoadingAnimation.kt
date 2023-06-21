package com.saehyun.presentation.component

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

private object LoadingAnimationSpec {
    const val AnimationTweenDurationMillis: Int = 1000
    const val InitialValue: Float = 0f
    const val TargetValue: Float = 1f
    const val DefaultLabel: String = ""
    val Size: Dp = 60.dp
}

@Composable
fun LoadingAnimation() = with(LoadingAnimationSpec) {
    val animation = rememberInfiniteTransition(label = DefaultLabel)
    val progress by animation.animateFloat(
        initialValue = InitialValue,
        targetValue = TargetValue,
        animationSpec = infiniteRepeatable(
            animation = tween(AnimationTweenDurationMillis),
            repeatMode = RepeatMode.Restart
        ),
        label = DefaultLabel
    )

    Box(
        modifier = Modifier
            .size(Size)
            .scale(progress)
            .alpha(1f - progress)
            .border(
                width = 5.dp,
                color = Color.Black,
                shape = CircleShape
            )
    )
}
