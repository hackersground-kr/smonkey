package com.project.smonkey.domain.journal.domain

import com.project.smonkey.domain.user.entity.User
import java.time.LocalDate
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "journal")
class Journal(
    title: String,
    content: String,
    date: LocalDate,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    val author: User,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0

    var title = title
        protected set

    var content = content
        protected set

    var date = date
        protected set

    fun updateJournal(
        title: String,
        content: String
    ): Journal {
        this.title = title
        this.content = content
        return this
    }
}
