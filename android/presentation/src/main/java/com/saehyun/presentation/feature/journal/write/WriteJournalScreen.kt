package com.saehyun.presentation.feature.journal.write

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.R
import com.saehyun.presentation.component.SMonkeyBaseTextField
import com.saehyun.presentation.component.SMonkeyLargeButton
import com.saehyun.presentation.component.SMonkeyMediumButton
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.component.TopAppBar
import com.saehyun.presentation.style.SmonkeyBody3
import com.saehyun.presentation.style.SmonkeyTextStyle

@Composable
fun WriteJournalScreen(
    title: String,
    content: String,
    selectedButton: Int,
    onTitleChanged: (String) -> Unit,
    onContentChanged: (String) -> Unit,
    onSelectedButtonChanged: (Int) -> Unit,
    onWrite: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp),
    ) {
        TopAppBar(
            leadingContent = {
                Image(
                    painter = painterResource(id = R.drawable.ic_back_24),
                    contentDescription = null,
                )
            },
            centerContent = {
                SmonkeyBody3(text = "일지 작성")
            }
        )
        Spacer(space = 30.dp)
        SMonkeyBaseTextField(
            value = title,
            onValueChange = onTitleChanged,
            textStyle = SmonkeyTextStyle.Body1,
            hint = "제목"
        )
        Spacer(space = 20.dp)
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            SMonkeyMediumButton(
                text = "금연 성공",
                enabled = selectedButton == QuitSmokingSuccessButton,
                color = Color.Blue,
            ) {
                onSelectedButtonChanged(QuitSmokingSuccessButton)
            }

            Spacer(weight = 1f)

            SMonkeyMediumButton(
                text = "금연 실패",
                enabled = selectedButton == QuitSmokingFailedButton,
                color = Color.Red,
            ) {
                onSelectedButtonChanged(QuitSmokingFailedButton)
            }
        }
        Spacer(space = 20.dp)
        SMonkeyBaseTextField(
            value = content,
            onValueChange = onContentChanged,
            textStyle = SmonkeyTextStyle.Body6,
            hint = "오늘의 금연을 기록하며 느낀점을 기록해보세요!",
        )
        Spacer(weight = 1f)
        SMonkeyLargeButton(
            text = "게시",
            enabled = title.isNotEmpty() && content.isNotEmpty(),
        ) {
            onWrite()
        }
        Spacer(space = 54.dp)
    }
}