package com.project.smonkey.domain.journal.domain.repository

import com.project.smonkey.domain.journal.domain.Journal
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface JournalRepository: JpaRepository<Journal, Long> {

    fun existsByDate(date: LocalDate): Boolean

    fun getByDate(date: LocalDate): Journal

    fun findAllByDateBetween(date: LocalDate, date2: LocalDate): List<Journal?>

}
