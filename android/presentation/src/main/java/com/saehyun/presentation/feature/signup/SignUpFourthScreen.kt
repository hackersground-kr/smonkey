package com.saehyun.presentation.feature.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.R
import com.saehyun.presentation.component.SMonkeyTextField
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.style.SmonkeyBody1

@Composable
fun SignUpFourthScreen(
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
    // 상태 저장할 필요 없음
    val checkMessage = remember { mutableStateOf("") }

    BaseProfileScreen(
        onPrevious = onPrevious,
        onNext = onNext,
        title = "금연 서약서",
        index = 3,
        maxIndex = 4
    ) {
        Spacer(space = 24.dp)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
        ) {
            Image(
                modifier = Modifier.fillMaxWidth(),
                painter = painterResource(id = R.drawable.bg_quit_smoking_check),
                contentDescription = null,
                contentScale = ContentScale.FillWidth,
            )
            Spacer(space = 16.dp)
            SmonkeyBody1(text = "금연을 시작 하기 전.. 다짐을 작성해보세요.")
            Spacer(space = 4.dp)
            SMonkeyTextField(
                value = checkMessage.value,
                onValueChange = { checkMessage.value = it },
            )
            Spacer(space = 70.dp)
        }
    }
}