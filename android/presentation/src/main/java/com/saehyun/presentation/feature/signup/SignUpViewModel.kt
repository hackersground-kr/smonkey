package com.saehyun.presentation.feature.signup

import androidx.lifecycle.ViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(

) : ContainerHost<SignUpState, SignUpSideEffect>, ViewModel() {

    override val container = container<SignUpState, SignUpSideEffect>(SignUpState())

    fun navigateStep(step: SignUpStep) = intent {
        reduce { state.copy(step = step) }
    }

    fun updateName(name: String) = intent {
        reduce {
            state.copy(name = name)
        }
    }

    fun updatePassword(password: String) = intent {
        reduce {
            state.copy(password = password)
        }
    }

    fun updatePasswordCheck(passwordCheck: String) = intent {
        reduce {
            state.copy(passwordCheck = passwordCheck)
        }
    }

    fun updateId(id: String) = intent {
        reduce {
            state.copy(id = id)
        }
    }

    fun updateEmail(email: String) = intent {
        reduce {
            state.copy(email = email)
        }
    }

    fun updateVerifyCode(verifyCode: String) = intent {
        reduce {
            state.copy(verifyCode = verifyCode)
        }
    }
}