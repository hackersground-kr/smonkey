package com.saehyun.presentation.feature.signup

data class SignUpState(
    val isLoading: Boolean = false,
    val step: SignUpStep = SignUpStep.STEP1,

    // 회원가입 1단계
    val name: String = "",
    val id: String = "",
    val password: String = "",
    val passwordCheck: String = "",

    // 회원가입 2단계
    val email: String = "",
    val verifyCode: String = "",
)

enum class SignUpStep(
    val index: Int,
) {
    STEP1(0),
    STEP2(1),
    STEP3(2),
    ;

    operator fun minus(previous: Int): SignUpStep {
        return values()[index - previous]
    }

    operator fun plus(next: Int): SignUpStep {
        return values()[index + next]
    }
}