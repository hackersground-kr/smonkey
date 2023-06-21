@file:OptIn(ExperimentalFoundationApi::class)

package com.saehyun.presentation.util

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import com.saehyun.common_kotlin.runIf

fun Modifier.smonkeyClickable(
    rippleEnabled: Boolean = true,
    rippleColor: Color? = null,
    onLongClick: (() -> Unit)? = null,
    onClick: (() -> Unit)?
): Modifier = runIf(
    condition = onClick != null
) {
    composed {
        combinedClickable(
            onClick = onClick!!,
            onLongClick = onLongClick,
            indication = rememberRipple(
                color = rippleColor ?: Color.Unspecified
            ).takeIf {
                rippleEnabled
            },
            interactionSource = remember { MutableInteractionSource() }
        )
    }
}
