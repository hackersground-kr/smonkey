package com.project.smonkey.domain.journal.presentation.dto.response

import com.project.smonkey.domain.journal.domain.Journal

data class JournalListResponse(
    val list: List<Journal?>
)
