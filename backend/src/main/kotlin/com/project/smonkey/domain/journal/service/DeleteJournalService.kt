package com.project.smonkey.domain.journal.service

import com.project.smonkey.domain.journal.domain.repository.JournalRepository
import com.project.smonkey.domain.journal.exception.NotMyJournalException
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service
import java.time.LocalDate
import javax.transaction.Transactional

@Service
class DeleteJournalService(
    private val userFacade: UserFacade,
    private val journalRepository: JournalRepository
) {

    @Transactional
    fun execute(
        date: LocalDate
    ):BaseResponse<Unit> {
        val author = userFacade.getCurrentUser()
        val journal = journalRepository.getByDate(date)

        if (journal.author != author) {
            throw NotMyJournalException
        }

        journalRepository.delete(journal)

        return BaseResponse(
            status = 204,
            message = "success delete journal",
            content = null
        )
    }

}
