package com.saehyun.presentation.feature.journal.write

import androidx.compose.runtime.Immutable

internal const val QuitSmokingSuccessButton = 0
internal const val QuitSmokingFailedButton = 1

@Immutable
data class WriteJournalState(
    val isLoading: Boolean = false,
    val title: String = "",
    val content: String = "",
    val selectedButton: Int = QuitSmokingSuccessButton,
)
