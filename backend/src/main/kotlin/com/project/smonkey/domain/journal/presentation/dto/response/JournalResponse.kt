package com.project.smonkey.domain.journal.presentation.dto.response

data class JournalResponse(
    val title: String,
    val content: String,
    val date: String,
    val userName: String,
    val smoking: Boolean
)
