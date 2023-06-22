package com.saehyun.presentation.feature.signup

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.saehyun.common_android.ColorType
import com.saehyun.presentation.R
import com.saehyun.presentation.component.SMonkeyTextField
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SmonkeyBody5
import com.saehyun.presentation.style.SmonkeyBody7
import com.saehyun.presentation.util.smonkeyClickable
import com.saehyun.presentation.util.toSMonkeyColor

@Composable
fun SignUpSixthScreen(
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    nickname: String,
    onNicknameChanged: (String) -> Unit,
    selectedColor: ColorType,
    onColorSelectedChanged: (ColorType) -> Unit,
) {
    val colors = ColorType.values().toList()

    BaseProfileScreen(
        onPrevious = onPrevious,
        onNext = onNext,
        title = "스몽키 만들기",
        index = 5,
        maxIndex = 5,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(SMonkeyColor.Gray100)
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(space = 24.dp)
            Image(
                modifier = Modifier.size(120.dp),
                painter = painterResource(id = R.drawable.character_smonkey_1),
                contentDescription = null,
            )
            Spacer(space = 4.dp)
            SmonkeyBody7(
                text = "장석연님의 스몽키",
                align = TextAlign.Center,
            )
            SmonkeyBody5(
                text = nickname,
                align = TextAlign.Center,
            )
            Spacer(space = 20.dp)
            SMonkeyTextField(
                value = nickname,
                onValueChange = onNicknameChanged,
                hint = "스몽키의 별명을 입력하세요!"
            )
            Spacer(space = 32.dp)
            LazyVerticalGrid(
                horizontalArrangement = Arrangement.spacedBy(19.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp),
                columns = GridCells.Fixed(8),
                content = {
                    items(colors) { color ->
                        Box(
                            modifier = Modifier
                                .size(35.dp)
                                .background(
                                    color = color.toSMonkeyColor(),
                                    shape = CircleShape,
                                )
                                .clip(CircleShape)
                                .smonkeyClickable {
                                    onColorSelectedChanged(color)
                                },
                            contentAlignment = Alignment.Center,
                        ) {
                            if (selectedColor == color) {
                                Image(
                                    modifier = Modifier.size(24.dp),
                                    painter = painterResource(id = R.drawable.ic_check_12),
                                    contentDescription = null,
                                )
                            }
                        }
                    }
                }
            )
            Spacer(space = 70.dp)
        }
    }
}