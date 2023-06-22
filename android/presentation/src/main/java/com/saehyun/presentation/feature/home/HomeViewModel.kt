package com.saehyun.presentation.feature.home

import androidx.lifecycle.ViewModel
import com.saehyun.data.repository.SmonkeyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val smonkeyRepository: SmonkeyRepository,
) : ContainerHost<HomeState, HomeSideEffect>, ViewModel() {

    override val container = container<HomeState, HomeSideEffect>(HomeState())

    fun getSmonkey() = intent {
        kotlin.runCatching {
            smonkeyRepository.getSmonkey()
        }.onSuccess { response ->
            val smonkey = response.content
            reduce {
                state.copy(
                    smonkey = SMonkeyUser(
                        backgroundColor = smonkey.backgroundColor,
                        level = smonkey.level,
                        nextPoint = smonkey.nextPoint,
                        point = smonkey.point,
                        smonkeyName = smonkey.smonkeyName,
                        step = smonkey.step,
                    ),
                    username = smonkey.userName
                )
            }
        }.onFailure { exception ->
            postSideEffect(HomeSideEffect.SendMessage(exception.message ?: ""))
        }
    }

    fun updateSelectedIndex(index: Int) = intent {
        reduce {
            state.copy(
                selectedIndex = index,
            )
        }
    }
}