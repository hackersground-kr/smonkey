package com.project.smonkey.domain.journal.presentation.dto.request

import com.project.smonkey.domain.journal.domain.Journal
import com.project.smonkey.domain.user.entity.User
import java.time.LocalDate
import java.util.Date

data class CreateJournalRequest(
    val title: String,
    val content: String,
    val date: LocalDate,
    val smoking: Boolean
) {

    fun toEntity(author: User): Journal {
        return Journal(
            title = this.title,
            content = this.content,
            date = this.date,
            author = author,
            smoking = this.smoking,
        )
    }

}
