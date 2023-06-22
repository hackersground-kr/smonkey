package com.saehyun.presentation.feature.journal

import androidx.lifecycle.ViewModel
import com.saehyun.common_kotlin.currentDate
import com.saehyun.common_kotlin.formatString
import com.saehyun.data.repository.JournalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class JournalViewModel @Inject constructor(
    private val journalRepository: JournalRepository,
) : ContainerHost<JournalState, JournalSideEffect>, ViewModel() {
    override val container = container<JournalState, JournalSideEffect>(JournalState())

    fun getJournal() = intent {
        kotlin.runCatching {
            journalRepository.getJournal(currentDate().formatString())
        }.onSuccess { response ->
            reduce {
                state.copy(
//                    quitSmokingDates = response.quitSmokingDates,
//                    smokingRelapseDates = response.smokingRelapseDates,
                )
            }
        }.onFailure { exception ->
        }
    }

    fun updateYear(year: Int) = intent {
        reduce {
            state.copy(journalYear = year)
        }
    }

    fun updateMonth(month: Int) = intent {
        reduce {
            state.copy(journalMonth = month)
        }
    }
}