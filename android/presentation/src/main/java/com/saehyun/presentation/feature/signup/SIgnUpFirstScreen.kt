package com.saehyun.presentation.feature.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.component.SMonkeyTextField
import com.saehyun.presentation.component.Spacer

@Composable
fun SignUpFirstScreen(
    state: SignUpState,
    modifier: Modifier = Modifier,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    updateName: (String) -> Unit,
    updateId: (String) -> Unit,
    updatePassword: (String) -> Unit,
    updatePasswordCheck: (String) -> Unit,
    updateAge: (String) -> Unit,
) {
    BaseSignUpScreen(
        modifier = modifier,
        onPrevious = onPrevious,
        index = 1,
        maxIndex = 3,
        title = "금연 관리 스몽키로!\n3단계면 시작해!",
        onNext = onNext,
    ) {
        Spacer(space = 80.dp)
        SMonkeyTextField(
            value = state.name,
            onValueChange = updateName,
            hint = "이름",
        )
        Spacer(space = 16.dp)
        SMonkeyTextField(
            value = state.id,
            onValueChange = updateId,
            hint = "아이디",
        )
        Spacer(space = 16.dp)
        SMonkeyTextField(
            value = state.password,
            onValueChange = updatePassword,
            hint = "비밀번호",
            isPassword = true,
        )
        Spacer(space = 16.dp)
        SMonkeyTextField(
            value = state.passwordCheck,
            onValueChange = updatePasswordCheck,
            hint = "비밀번호 재확인",
            isPassword = true,
        )
        Spacer(space = 16.dp)
        SMonkeyTextField(
            value = state.age,
            onValueChange = updateAge,
            hint = "나이",
            keyboardType = KeyboardType.Number,
        )
    }
}
