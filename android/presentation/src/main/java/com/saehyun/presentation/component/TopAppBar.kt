package com.saehyun.presentation.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
internal fun TopAppBar(
    modifier: Modifier = Modifier,
    leadingContent: (@Composable () -> Unit)? = null,
    centerContent: (@Composable () -> Unit)? = null,
    trailingContent: (@Composable () -> Unit)? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp),
        contentAlignment = Alignment.Center
    ) {
        leadingContent?.let {
            Box(modifier = Modifier.align(Alignment.CenterStart)) {
                it()
            }
        }

        centerContent?.let {
            Box(modifier = Modifier.align(Alignment.Center)) {
                it()
            }
        }

        trailingContent?.let {
            Box(modifier = Modifier.align(Alignment.CenterEnd)) {
                it()
            }
        }
    }
}
