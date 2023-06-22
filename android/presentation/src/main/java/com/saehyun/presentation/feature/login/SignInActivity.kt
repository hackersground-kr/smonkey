package com.saehyun.presentation.feature.login

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.R
import com.saehyun.presentation.component.SMonkeyLargeButton
import com.saehyun.presentation.component.SMonkeyTextField
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.feature.home.HomeActivity
import com.saehyun.presentation.style.SMonkeyTheme
import com.saehyun.presentation.style.SmonkeyBody10
import com.saehyun.presentation.util.ToastWrapper
import com.saehyun.presentation.util.startActivityWithAnimation
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe
import javax.inject.Inject

@AndroidEntryPoint
class SignInActivity : ComponentActivity() {

    private val vm: SignInViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            vm.observe(
                lifecycleOwner = this,
                sideEffect = ::handleSideEffect,
            )

            val state = vm.container.stateFlow.collectAsState().value

            SMonkeyTheme {
                SignInScreen(
                    state = state,
                    onIdChanged = vm::updateId,
                    onPasswordChanged = vm::updatePassword,
                    onClickLogin = vm::signIn
                )
            }
        }
    }

    private fun handleSideEffect(sideEffect: SignInSideEffect) {
        when (sideEffect) {
            is SignInSideEffect.SendMessage -> {
                Toast.makeText(this, sideEffect.message, Toast.LENGTH_SHORT).show()
            }

            is SignInSideEffect.NavigateToHome -> {
                navigateToHome()
            }
        }
    }

    private fun navigateToHome() {
        startActivityWithAnimation<HomeActivity>() // TODO singleTOP
    }
}

@Composable
private fun SignInScreen(
    modifier: Modifier = Modifier,
    state: SignInState,
    onIdChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onClickLogin: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .systemBarsPadding()
            .padding(horizontal = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(space = 110.dp)
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier
                    .size(80.dp),
                painter = painterResource(id = R.drawable.character_smonkey_1),
                contentDescription = null,
            )
            Image(
                painter = painterResource(id = R.drawable.ic_smonkey_title),
                contentDescription = null,
            )
        }
        Spacer(space = 40.dp)
        SMonkeyTextField(
            value = state.id,
            onValueChange = onIdChanged,
            hint = "아이디",
        )
        Spacer(space = 16.dp)
        SMonkeyTextField(
            value = state.password,
            onValueChange = onPasswordChanged,
            hint = "비밀번호",
        )
        Spacer(space = 12.dp)
        SmonkeyBody10(
            modifier = Modifier.fillMaxWidth(),
            text = "아직 회원이 아니신가요? 회원가입",
            align = TextAlign.End,
        )
        Spacer(space = 16.dp)
        SMonkeyLargeButton(
            text = "다음",
            enabled = true,
        ) {
            onClickLogin()
        }
    }
}
