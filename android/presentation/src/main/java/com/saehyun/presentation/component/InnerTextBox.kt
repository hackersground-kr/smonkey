package com.saehyun.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody7

@Composable
fun InnerTextBox(
    text: String,
) {
    Box(
        modifier = Modifier
            .size(28.dp)
            .border(
                width = 1.dp,
                color = SMonkeyColor.Gray900,
                shape = CircleShape,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Box(
            modifier = Modifier
                .size(20.dp)
                .background(
                    shape = CircleShape,
                    color = Color.Black,
                ),
            contentAlignment = Alignment.Center,
        ) {
            SmonkeyBody7(text = text, color = Color.White)
        }
    }
}

@Preview
@Composable
fun PreviewTextBox() {
    InnerTextBox(text = "1")
}