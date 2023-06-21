package com.saehyun.presentation.feature.signup

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.component.SMonkeyTextField
import com.saehyun.presentation.component.Spacer

@Composable
fun SignUpSecondScreen(
    modifier: Modifier = Modifier,
    state: SignUpState,
    vm: SignUpViewModel,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
) {
    BaseSignUpScreen(
        modifier = modifier,
        index = 2,
        maxIndex = 3,
        title = "한 단계 남았어요!\n좀만 더 화이팅!",
        onPrevious = onPrevious,
        onNext = onNext
    ) {
        Spacer(space = 80.dp)
        SMonkeyTextField(
            value = state.email,
            onValueChange = { email ->
                vm.updateEmail(email)
            },
            hint = "이메일",
        )
        Spacer(space = 16.dp)
        SMonkeyTextField(
            value = state.verifyCode,
            onValueChange = { verifyCode ->
                vm.updateVerifyCode(verifyCode)
            },
            hint = "인증 코드",
        )
    }
}
