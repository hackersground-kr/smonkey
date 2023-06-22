package com.saehyun.presentation.feature.journal

import com.saehyun.data.network.journal.JournalResponse
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalDate

data class JournalState(
    val journalYear: Int = currentYear(),
    val journalMonth: Int = currentMonth(),
    val quitSmokingDates: ImmutableList<JournalResponse> = persistentListOf(),
    val smokingRelapseDates: ImmutableList<JournalResponse> = persistentListOf(),
)

private fun currentYear(): Int =
    LocalDate.now().year

private fun currentMonth(): Int =
    LocalDate.now().month.value