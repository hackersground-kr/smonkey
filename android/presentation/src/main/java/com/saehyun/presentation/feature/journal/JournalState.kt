package com.saehyun.presentation.feature.journal

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import java.time.LocalDate

data class JournalState(
    val journalYear: Int = currentYear(),
    val journalMonth: Int = currentMonth(),
    val quitSmokingDates: ImmutableList<Int> = persistentListOf(),
    val smokingRelapseDates: ImmutableList<Int> = persistentListOf(),
)

private fun currentYear(): Int =
    LocalDate.now().year

private fun currentMonth(): Int =
    LocalDate.now().month.value