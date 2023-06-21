package com.saehyun.presentation.feature.login

import androidx.lifecycle.ViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

class SignInViewModel @Inject constructor(

) : ContainerHost<SignInState, SignInSideEffect>, ViewModel() {

    override val container = container<SignInState, SignInSideEffect>(SignInState())

    fun updateId(id: String) = intent {
        reduce { state.copy(id = id) }
    }

    fun updatePassword(password: String) = intent {
        reduce { state.copy(password = password) }
    }
}