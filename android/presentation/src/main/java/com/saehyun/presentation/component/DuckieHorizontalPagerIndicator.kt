@file:OptIn(ExperimentalFoundationApi::class)

package com.saehyun.presentation.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.style.SMonkeyColor

@Composable
fun SMonkeyHorizontalPagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pageCount: Int,
    activeColor: Color = SMonkeyColor.Black,
    inactiveColor: Color = SMonkeyColor.Gray300,
    indicatorWidth: Dp = 12.dp,
    selectIndicatorWidth: Dp = 24.dp,
    indicatorHeight: Dp = indicatorWidth,
    spacing: Dp = 8.dp,
    indicatorShape: Shape = CircleShape,
) {
    val indicatorWidthPx = LocalDensity.current.run { indicatorWidth.roundToPx() }
    val spacingPx = LocalDensity.current.run { spacing.roundToPx() }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.CenterStart,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(spacing),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            val indicatorModifier = Modifier
                .size(width = indicatorWidth, height = indicatorHeight)
                .background(color = inactiveColor, shape = indicatorShape)

            val selectIndicatorModifier = Modifier
                .size(width = selectIndicatorWidth, height = indicatorHeight)
                .background(color = inactiveColor, shape = indicatorShape)

            repeat(pageCount) { index ->
                if (index == pagerState.currentPage) {
                    Box(selectIndicatorModifier)
                } else {
                    Box(indicatorModifier)
                }
            }
        }

        Box(
            Modifier
                .offset {
                    val scrollPosition =
                        (pagerState.currentPage + pagerState.currentPageOffsetFraction)
                            .coerceIn(
                                0f,
                                pagerState.currentPage
                                    .coerceAtLeast(0)
                                    .toFloat()
                            )
                    IntOffset(
                        x = ((spacingPx + indicatorWidthPx) * scrollPosition).toInt(),
                        y = 0,
                    )
                }
                .size(width = selectIndicatorWidth, height = indicatorHeight)
                .background(
                    color = activeColor,
                    shape = indicatorShape,
                ),
        )
    }
}
