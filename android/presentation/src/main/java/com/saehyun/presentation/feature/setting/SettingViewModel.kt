package com.saehyun.presentation.feature.setting

import androidx.lifecycle.ViewModel
import com.saehyun.data.repository.SmonkeyRepository
import com.saehyun.presentation.feature.home.HomeSideEffect
import com.saehyun.presentation.feature.home.SMonkeyUser
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val smonkeyRepository: SmonkeyRepository,
) : ContainerHost<SettingState, SettingSideEffect>, ViewModel() {
    override val container = container<SettingState, SettingSideEffect>(SettingState())

    init {
        getSmonkey()
    }

    fun getSmonkey() = intent {
        kotlin.runCatching {
            smonkeyRepository.getSmonkey()
        }.onSuccess { response ->
            val entity = response.content
            reduce {
                state.copy(
                    smonkey = SMonkeyUser(
                        backgroundColor = entity.backgroundColor,
                        level = entity.level,
                        nextPoint = entity.nextPoint,
                        point = entity.point,
                        smonkeyName = entity.smonkeyName,
                        step = entity.step,
                        percentage = entity.percentage,
                    ),
                    username = entity.userName,
                )
            }
        }.onFailure { exception ->

        }
    }
}