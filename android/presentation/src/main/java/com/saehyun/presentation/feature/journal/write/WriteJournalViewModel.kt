package com.saehyun.presentation.feature.journal.write

import androidx.lifecycle.ViewModel
import com.saehyun.common_kotlin.currentDate
import com.saehyun.common_kotlin.formatString
import com.saehyun.data.network.journal.JournalRequest
import com.saehyun.data.repository.JournalRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class WriteJournalViewModel @Inject constructor(
    private val journalRepository: JournalRepository,
) : ContainerHost<WriteJournalState, WriteJournalSideEffect>, ViewModel() {
    override val container =
        container<WriteJournalState, WriteJournalSideEffect>(WriteJournalState())

    fun writeJournal() = intent {
        val request = JournalRequest(
            title = state.title,
            content = state.content,
            date = currentDate().formatString(),
        )
        kotlin.runCatching {
            journalRepository.writeJournal(request)
        }.onSuccess {
            postSideEffect(WriteJournalSideEffect.Success)
        }.onFailure { exception ->
            when {
                exception.message?.contains("409") == true -> {
                    postSideEffect(WriteJournalSideEffect.SendMessage("이미 일지를 등록했어요!"))
                }

                else -> {
                    postSideEffect(WriteJournalSideEffect.SendMessage(exception.message ?: ""))
                }
            }
        }
    }

    fun updateTitle(title: String) = intent {
        reduce {
            state.copy(
                title = title,
            )
        }
    }

    fun updateContent(content: String) = intent {
        reduce {
            state.copy(
                content = content,
            )
        }
    }

    fun updateSelectedButton(selectedButton: Int) = intent {
        reduce {
            state.copy(
                selectedButton = selectedButton,
            )
        }
    }
}