package com.project.smonkey.domain.journal.presentation

import com.project.smonkey.domain.journal.presentation.dto.request.CreateJournalRequest
import com.project.smonkey.domain.journal.presentation.dto.response.JournalListResponse
import com.project.smonkey.domain.journal.presentation.dto.response.JournalResponse
import com.project.smonkey.domain.journal.service.CreateJournalService
import com.project.smonkey.domain.journal.service.DeleteJournalService
import com.project.smonkey.domain.journal.service.FindAllMonthJournalService
import com.project.smonkey.domain.journal.service.FindJournalService
import com.project.smonkey.global.payload.BaseResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate

@Api(tags = ["금연 일지 API"], description = "금연 일지 API")
@RestController
@RequestMapping("/journal")
class JournalController(
    private val createJournalService: CreateJournalService,
    private val deleteJournalService: DeleteJournalService,
    private val findJournalService: FindJournalService,
    private val findAllMonthJournalService: FindAllMonthJournalService
) {

    @ApiOperation(value = "금연 일지 작성하기")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createJournal(
        @RequestBody request: CreateJournalRequest
    ): BaseResponse<Unit> {
        return createJournalService.execute(request)
    }

    @ApiOperation(value = "금연 일지 가져오기")
    @GetMapping
    fun getJournal(
        @RequestParam("date") date: LocalDate
    ): BaseResponse<JournalResponse> {
        return findJournalService.execute(date)
    }

    @ApiOperation(value = "금연 일지 삭제하기")
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteJournal(
        @RequestParam("date") data: LocalDate
    ): BaseResponse<Unit> {
        return deleteJournalService.execute(data)
    }

    @ApiOperation(value = "금연 일지 월별로 가져오기")
    @GetMapping("/month")
    fun getDataByMonth(
        @RequestParam("year") year: Int,
        @RequestParam("month") month: Int,
    ): BaseResponse<JournalListResponse> {
        return findAllMonthJournalService.execute(year, month)
    }

}
