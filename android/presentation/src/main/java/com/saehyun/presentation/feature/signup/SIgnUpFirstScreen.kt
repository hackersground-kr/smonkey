package com.saehyun.presentation.feature.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.component.SMonkeyTextField
import com.saehyun.presentation.component.Spacer

@Composable
fun SignUpFirstScreen(
    modifier: Modifier = Modifier,
    state: SignUpState,
    vm: SignUpViewModel,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
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
            onValueChange = { name ->
                vm.updateName(name)
            },
            hint = "이름",
        )
        Spacer(space = 16.dp)
        SMonkeyTextField(
            value = state.id,
            onValueChange = { id ->
                vm.updateId(id)
            },
            hint = "아이디",
        )
        Spacer(space = 16.dp)
        SMonkeyTextField(
            value = state.password,
            onValueChange = { password ->
                vm.updatePassword(password)
            },
            hint = "비밀번호",
        )
        Spacer(space = 16.dp)
        SMonkeyTextField(
            value = state.name,
            onValueChange = { passwordCheck ->
                vm.updatePasswordCheck(passwordCheck)
            },
            hint = "비밀번호 재확인",
        )
    }
}
