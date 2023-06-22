package com.project.smonkey.domain.journal.service

import com.project.smonkey.domain.journal.domain.repository.JournalRepository
import com.project.smonkey.domain.journal.presentation.dto.response.JournalListResponse
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
class FindAllMonthJournalService(
    private val userFacade: UserFacade,
    private val journalRepository: JournalRepository,
) {

    @Transactional
    fun execute(
        year: Int,
        month: Int,
    ): BaseResponse<JournalListResponse> {
        val user = userFacade.getCurrentUser()

        var day = 0
        if (month == 2) {
            day = 27
        } else {
            day = if (month < 8) {
                if (month % 2 == 0) 30 else 31
            } else {
                if (month % 2 == 0) 31 else 30
            }
        }

        val startDate = LocalDate.of(year, month, 1)
        val endDate = LocalDate.of(year, month, day)

        val list = journalRepository.findAllByDateBetween(startDate, endDate)

        return BaseResponse(
            status = 200,
            message = "success find journal data",
            content = JournalListResponse(
                list = list
            )
        )
    }

}
