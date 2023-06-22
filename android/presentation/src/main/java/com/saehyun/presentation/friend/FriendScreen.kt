package com.saehyun.presentation.friend

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.data.network.feed.Writer
import com.saehyun.presentation.R
import com.saehyun.presentation.component.BigTopAppBar
import com.saehyun.presentation.component.SMonkeyLinearProgressBar
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.component.toSmonkeyCharacter
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody1
import com.saehyun.presentation.style.SmonkeyBody10
import com.saehyun.presentation.style.SmonkeyBody7

@Composable
fun FriendScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SMonkeyColor.Gray200),
    ) {
        BigTopAppBar(
            leadingContent = {
                SmonkeyBody1(text = "친구")
            },
            trailingContent = {
                Row {
                    Image(
                        painter = painterResource(id = R.drawable.ic_search_green_24),
                        contentDescription = null,
                    )
                    Spacer(space = 24.dp)
                    Image(
                        painter = painterResource(id = R.drawable.ic_add_friend_green_24),
                        contentDescription = null,
                    )
                }
            },
        )
        Spacer(space = 12.dp)
        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(id = R.drawable.bg_friend),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )
    }
}

@Composable
fun FriendPreviewLayout(
    writer: Writer,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            )
    ) {
        Image(
            modifier = Modifier.size(36.dp),
            painter = painterResource(id = writer.step.toSmonkeyCharacter()),
            contentDescription = null,
        )
        Spacer(space = 12.dp)
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                SmonkeyBody7(text = writer.userName)
                Spacer(space = 6.dp)
                SmonkeyBody10(
                    text = buildString {
                        append(writer.smonkeyName)
                        append("  (")
                        append("Lv. ${writer.level}), ")
                        append(writer.point)
                    },
                    color = SMonkeyColor.Gray500,
                )
            }
            Spacer(space = 4.dp)
            SMonkeyLinearProgressBar(progress = 0.8f)
        }
    }
}
