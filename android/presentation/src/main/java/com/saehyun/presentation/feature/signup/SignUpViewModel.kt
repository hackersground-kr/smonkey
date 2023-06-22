package com.saehyun.presentation.feature.signup

import androidx.lifecycle.ViewModel
import com.saehyun.common_android.ColorType
import com.saehyun.common_kotlin.SlingDateParsingPattern
import com.saehyun.common_kotlin.formatString
import com.saehyun.data.network.smonkey.BackgroundColorRequest
import com.saehyun.data.network.user.SignUpRequest
import com.saehyun.data.repository.SmonkeyRepository
import com.saehyun.data.repository.UserRepository
import com.saehyun.presentation.util.toLocalDateTime
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val smonkeyRepository: SmonkeyRepository
) : ContainerHost<SignUpState, SignUpSideEffect>, ViewModel() {

    override val container = container<SignUpState, SignUpSideEffect>(SignUpState())

    private fun changeSmonkeyBackgroundColor(colorType: ColorType) = intent {
        kotlin.runCatching {
            smonkeyRepository.changeBackgroundColor(
                BackgroundColorRequest(colorType.toString())
            )
        }.onFailure { exception ->
            postSideEffect(SignUpSideEffect.SendMessage(exception.message ?: ""))
        }
    }

    fun signUp() = intent {
        changeSmonkeyBackgroundColor(state.selectedColor)

        val request = SignUpRequest(
            accountId = state.id,
            age = state.age.toIntOrNull() ?: 0,
            email = state.email,
            name = state.name,
            password = state.password,
            amount = state.avgDailySmokeCount.toIntOrNull() ?: 0,
            cigaretteAmount = state.smokePerPack.toIntOrNull() ?: 0,
            noSmokingDate = state.quitSmokingStartAt.formatString(SlingDateParsingPattern.ISO8601Format),
            price = state.price.toIntOrNull() ?: 0,
            reason = state.reason.title,
            smokingDate = state.smokingStartAt.formatString(SlingDateParsingPattern.ISO8601Format),
            sMonkeyName = state.nickname,
            backgroundColor = state.selectedColor,
        )

        kotlin.runCatching {
            userRepository.signUp(request)
        }.onSuccess {
            postSideEffect(SignUpSideEffect.NavigateToHome)
        }.onFailure { exception ->
            postSideEffect(SignUpSideEffect.NavigateBack)
            postSideEffect(SignUpSideEffect.SendMessage(exception.message ?: ""))
        }
    }

    fun updateReason(reason: SmokingCessationReason) = intent {
        reduce {
            state.copy(reason = reason)
        }
    }

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

    fun updateAge(age: String) = intent {
        reduce {
            state.copy(age = age)
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

    fun updateAvgDailySmokeCount(avgDailySmokeCount: String) = intent {
        reduce {
            state.copy(avgDailySmokeCount = avgDailySmokeCount)
        }
    }

    fun updatePrice(price: String) = intent {
        reduce {
            state.copy(price = price)
        }
    }

    fun updateSmokingStartAt(smokingStartAt: Date) = intent {
        reduce {
            state.copy(smokingStartAt = smokingStartAt)
        }
    }

    fun updateQuitSmokingStartAt(quitSmokingStartAt: Date) = intent {
        reduce {
            state.copy(quitSmokingStartAt = quitSmokingStartAt)
        }
    }

    fun updateSmokePerPack(smokePerPack: String) = intent {
        reduce {
            state.copy(smokePerPack = smokePerPack)
        }
    }

    fun updateNickname(nickname: String) = intent {
        reduce {
            state.copy(nickname = nickname)
        }
    }

    fun updateSelectedColor(selectedColor: ColorType) = intent {
        reduce {
            state.copy(selectedColor = selectedColor)
        }
    }
}