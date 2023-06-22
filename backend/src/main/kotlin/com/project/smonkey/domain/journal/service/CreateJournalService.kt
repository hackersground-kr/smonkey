package com.project.smonkey.domain.journal.service

import com.project.smonkey.domain.journal.domain.repository.JournalRepository
import com.project.smonkey.domain.journal.exception.JournalAlreadyExistsException
import com.project.smonkey.domain.journal.presentation.dto.request.CreateJournalRequest
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class CreateJournalService(
    private val userFacade: UserFacade,
    private val journalRepository: JournalRepository
) {

    @Transactional
    fun execute(
        request: CreateJournalRequest
    ): BaseResponse<Unit> {
        val author = userFacade.getCurrentUser()

        if (journalRepository.existsByDate(request.date)) {
            throw JournalAlreadyExistsException
        }

        journalRepository.save(request.toEntity(author))

        return BaseResponse(
            status = 201,
            message = "success create journal",
            content = null
        )
    }

}
