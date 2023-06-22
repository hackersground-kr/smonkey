package com.saehyun.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.R
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody10
import com.saehyun.presentation.style.SmonkeyBody5
import com.saehyun.presentation.style.SmonkeyBody8

@Composable
fun SMonkeyLayout(
    username: String,
    level: Int,
    smonkeyName: String,
    nextPoint: Int,
    point: Int,
    percentage: Float,
) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
            .background(
                shape = RoundedCornerShape(12.dp),
                color = SMonkeyColor.Gray100,
            )
            .padding(
                horizontal = 16.dp,
                vertical = 18.dp,
            ),
    ) {
        Image(
            modifier = Modifier.size(80.dp),
            painter = painterResource(id = R.drawable.character_smonkey_1),
            contentDescription = null,
        )
        Column {
            Row {
                SmonkeyBody5(text = username)
                SmonkeyBody8(text = "님의 스몽키")
            }
            Spacer(space = 4.dp)
            SmonkeyBody8(text = "Level ${level}. $smonkeyName")
            Spacer(space = 20.dp)
            SmonkeyBody10(text = "현재 포인트 $point / 남은 포인트 ${nextPoint - point}")
            Spacer(space = 8.dp)
            LinearProgressIndicator(
                progress = percentage,
                color = SMonkeyColor.Main1,
            )
        }
    }
}