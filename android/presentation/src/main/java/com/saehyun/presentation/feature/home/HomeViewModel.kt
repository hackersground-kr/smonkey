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

    fun navigateToWriteJournal() = intent {
        postSideEffect(HomeSideEffect.NavigateToWriteJournal)
    }

    fun getSmonkey() = intent {
        kotlin.runCatching {
            smonkeyRepository.getSmonkey()
        }.onSuccess { response ->
            val entity = response.content
            val quitSmokingDate = buildString {
                append(entity.smokingDates.noSmokingDay)
                append("일 ")
                append(entity.smokingDates.noSmokingHour)
                append("시간 ")
                append(entity.smokingDates.noSmokingMinute)
                append("분 ")
                append(entity.smokingDates.noSmokingSecond)
                append("초")
            }
            val smokingDate = buildString {
                append(entity.smokingDates.smokingDay)
                append("일 ")
                append(entity.smokingDates.smokingHour)
                append("시간 ")
                append(entity.smokingDates.smokingMinute)
                append("분 ")
                append(entity.smokingDates.smokingSecond)
                append("초")
            }
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
                    quitSmokingDate = quitSmokingDate,
                    smokingDate = smokingDate,
                    savePrice = state.savePrice,
                    spendPrice = state.spendPrice,
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