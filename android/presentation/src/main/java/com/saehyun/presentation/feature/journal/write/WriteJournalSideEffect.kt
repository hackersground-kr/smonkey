package com.saehyun.presentation.feature.journal.write

sealed class WriteJournalSideEffect {
    object Success: WriteJournalSideEffect()
    data class SendMessage(val message: String): WriteJournalSideEffect()
}
