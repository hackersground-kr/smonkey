package com.saehyun.presentation.feature.login

import androidx.lifecycle.ViewModel
import com.saehyun.data.network.user.SignInRequest
import com.saehyun.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val userRepository: UserRepository,
) : ContainerHost<SignInState, SignInSideEffect>, ViewModel() {

    override val container = container<SignInState, SignInSideEffect>(SignInState())

    fun signIn() = intent {
        val request = SignInRequest(
            accountId = state.id,
            password = state.password
        )
        kotlin.runCatching {
            userRepository.signIn(request)
        }.onSuccess {
            postSideEffect(SignInSideEffect.NavigateToHome)
        }.onFailure { exception ->
            postSideEffect(SignInSideEffect.SendMessage(exception.message ?: ""))
        }
    }

    fun updateId(id: String) = intent {
        reduce { state.copy(id = id) }
    }

    fun updatePassword(password: String) = intent {
        reduce { state.copy(password = password) }
    }
}