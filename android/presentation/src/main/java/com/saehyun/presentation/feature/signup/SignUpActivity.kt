package com.saehyun.presentation.feature.signup

import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.saehyun.presentation.component.InnerTextBox
import com.saehyun.presentation.component.SMonkeyLargeButton
import com.saehyun.presentation.component.SMonkeySimpleLayout
import com.saehyun.presentation.component.SMonkeyTextField
import com.saehyun.presentation.component.Spacer
import com.saehyun.presentation.component.TopAppBar
import com.saehyun.presentation.feature.home.HomeActivity
import com.saehyun.presentation.feature.home.HomeSideEffect
import com.saehyun.presentation.style.SMonkeyColor
import com.saehyun.presentation.style.SMonkeyIcon
import com.saehyun.presentation.style.SmonkeyBody3
import com.saehyun.presentation.util.finishWithAnimation
import com.saehyun.presentation.util.smonkeyClickable
import com.saehyun.presentation.util.startActivityWithAnimation
import com.saehyun.presentation.util.systemBarPaddings
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe

@AndroidEntryPoint
class SignUpActivity : ComponentActivity() {

    private val vm: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        setContent {
            val state = vm.container.stateFlow.collectAsState().value

            Crossfade(
                targetState = state.step,
                label = "",
            ) { step ->
                when (step) {
                    SignUpStep.STEP1 -> SignUpFirstScreen(
                        state = state,
                        onPrevious = {
                            finishWithAnimation()
                        },
                        onNext = {
                            vm.navigateStep(SignUpStep.STEP2)
                        },
                        updateAge = vm::updateAge,
                        updateId = vm::updateId,
                        updateName = vm::updateName,
                        updatePassword = vm::updatePassword,
                        updatePasswordCheck = vm::updatePasswordCheck
                    )

                    SignUpStep.STEP2 -> SignUpSecondScreen(
                        state = state,
                        onPrevious = {
                            vm.navigateStep(SignUpStep.STEP1)
                        },
                        onNext = {
                            vm.navigateStep(SignUpStep.STEP3)
                        },
                        updateEmail = vm::updateEmail,
                        updateVerifyCode = vm::updateVerifyCode,
                    )

                    SignUpStep.STEP3 -> SignUpThirdScreen(
                        onPrevious = {
                            vm.navigateStep(SignUpStep.STEP2)
                        },
                        onNext = {
                            vm.navigateStep(SignUpStep.STEP4)
                        },
                        onReasonChanged = vm::updateReason,
                        selectedReason = state.reason,
                    )

                    SignUpStep.STEP4 -> SignUpFourthScreen(
                        onPrevious = { vm.navigateStep(SignUpStep.STEP3) },
                        onNext = { vm.navigateStep(SignUpStep.STEP5) },

                        )

                    SignUpStep.STEP5 -> SignUpFifthScreen(
                        onPrevious = { vm.navigateStep(SignUpStep.STEP4) },
                        onNext = { vm.navigateStep(SignUpStep.STEP6) },
                        avgDailySmokeCount = state.avgDailySmokeCount,
                        updateAvgDailySmokeCount = vm::updateAvgDailySmokeCount,
                        price = state.price,
                        updatePrice = vm::updatePrice,
                        updateSmokingStartAt = vm::updateSmokingStartAt,
                        updateQuitSmokingStartAt = vm::updateQuitSmokingStartAt,
                        smokePerPack = state.smokePerPack,
                        updateSmokePerPack = vm::updateSmokePerPack,
                    )

                    SignUpStep.STEP6 -> SignUpSixthScreen(
                        onPrevious = { vm.navigateStep(SignUpStep.STEP5) },
                        onNext = { vm.signUp() },
                        nickname = state.nickname,
                        onNicknameChanged = vm::updateNickname,
                        selectedColor = state.selectedColor,
                        onColorSelectedChanged = vm::updateSelectedColor
                    )
                }
            }
        }

        vm.observe(
            lifecycleOwner = this,
            sideEffect = ::handleSideEffect,
        )
    }

    private fun handleSideEffect(sideEffect: SignUpSideEffect) {
        when (sideEffect) {
            is SignUpSideEffect.SendMessage -> {
                Toast.makeText(this, sideEffect.message, Toast.LENGTH_SHORT).show()
            }

            is SignUpSideEffect.NavigateToHome -> {
                startActivityWithAnimation<HomeActivity>()
            }

            is SignUpSideEffect.NavigateBack -> {
                finishWithAnimation()
            }
        }
    }
}

@Composable
fun BaseSignUpScreen(
    modifier: Modifier = Modifier,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    title: String,
    index: Int,
    maxIndex: Int,
    content: @Composable ColumnScope.() -> Unit,
) {
    SMonkeySimpleLayout(
        topAppBar = {
            TopAppBar(
                leadingContent = {
                    Image(
                        modifier = Modifier.smonkeyClickable {
                            onPrevious()
                        },
                        painter = painterResource(id = SMonkeyIcon.Back),
                        contentDescription = null,
                    )
                },
                centerContent = {
                    SmonkeyBody3(text = "회원가입")
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(space = 16.dp)
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    if (index == 1) Spacer(modifier = Modifier.weight(1f)) else Divider(
                        modifier = Modifier.weight(1f),
                        color = SMonkeyColor.Gray300,
                    )
                    InnerTextBox(text = index.toString())
                    if (index == maxIndex) Spacer(modifier = Modifier.weight(1f)) else Divider(
                        modifier = Modifier.weight(1f),
                        color = SMonkeyColor.Gray300,
                    )
                }
                Spacer(space = 34.dp)
                SmonkeyBody3(
                    text = title,
                    align = TextAlign.Center,
                )
                content()
            }
        },
        bottomContent = {
            SMonkeyLargeButton(
                modifier = Modifier
                    .imePadding(),
                text = "다음",
                enabled = true,
            ) {
                onNext()
            }
        }
    )
}

@Composable
fun BaseProfileScreen(
    modifier: Modifier = Modifier,
    onPrevious: () -> Unit,
    onNext: () -> Unit,
    title: String,
    index: Int,
    maxIndex: Int,
    content: @Composable ColumnScope.() -> Unit,
) {
    SMonkeySimpleLayout(
        topAppBar = {
            TopAppBar(
                leadingContent = {
                    Image(
                        modifier = Modifier.smonkeyClickable {
                            onPrevious()
                        },
                        painter = painterResource(id = SMonkeyIcon.Back),
                        contentDescription = null,
                    )
                },
                centerContent = {
                    SmonkeyBody3(text = title)
                }
            )
        },
        content = {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(space = 16.dp)
                content()
            }
        },
        bottomContent = {
            SMonkeyLargeButton(
                modifier = Modifier
                    .imePadding(),
                text = "다음",
                enabled = true,
            ) {
                onNext()
            }
        }
    )
}
