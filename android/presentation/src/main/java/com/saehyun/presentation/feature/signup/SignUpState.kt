package com.saehyun.presentation.feature.signup

import com.saehyun.common_android.ColorType
import com.saehyun.common_kotlin.currentDate
import java.time.LocalDateTime
import java.util.Date
import javax.annotation.concurrent.Immutable

@Immutable
data class SignUpState(
    val isLoading: Boolean = false,
    val step: SignUpStep = SignUpStep.STEP1,

    // 회원가입 1단계
    val name: String = "",
    val id: String = "",
    val password: String = "",
    val passwordCheck: String = "",
    val age: String = "",

    // 회원가입 2단계
    val email: String = "",
    val verifyCode: String = "",

    // 회원가입 3단계
    val reason: SmokingCessationReason = SmokingCessationReason.HEALTH,

    // 회원가입 5단계
    val avgDailySmokeCount: String = "",
    val price: String = "",
    val smokingStartAt: Date = currentDate(),
    val quitSmokingStartAt: Date = currentDate(),
    val smokePerPack: String = "",

    // 회원가입 6단계
    val nickname: String = "",
    val selectedColor: ColorType = ColorType.LightBlue,
)

enum class SignUpStep(
    val index: Int,
) {
    STEP1(0),
    STEP2(1),
    STEP3(2),
    STEP4(3),
    STEP5(4),
    STEP6(5)
    ;

    operator fun minus(previous: Int): SignUpStep {
        return values()[index - previous]
    }

    operator fun plus(next: Int): SignUpStep {
        return values()[index + next]
    }
}