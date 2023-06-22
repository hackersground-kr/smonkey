package com.project.smonkey.domain.smoking.controller

import com.project.smonkey.domain.smoking.payload.request.PostSmokingRequest
import com.project.smonkey.domain.smoking.service.DeductedPointService
import com.project.smonkey.domain.smoking.service.FailedSmokingService
import com.project.smonkey.domain.smoking.service.PostSmokingService
import com.project.smonkey.domain.smoking.service.SuccessSmokingService
import com.project.smonkey.global.payload.BaseResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Api(tags = ["금연 API"], description = "금연 API")
@RequestMapping("/smoking")
@RestController
class SmokingController(
    private val postSmokingService: PostSmokingService,
    private val deductedPointService: DeductedPointService,
    private val successSmokingService: SuccessSmokingService,
    private val failedSmokingService: FailedSmokingService
) {

    @ApiOperation(value = "금연 정보 등록")
    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    fun postSmoking(
        @RequestBody request: PostSmokingRequest,
    ): BaseResponse<Unit> {
        return postSmokingService.postSmoking(
            request = request,
        )
    }

    @ApiOperation(value = "금연 실패")
    @PostMapping("/failed")
    fun deductedPoint(): BaseResponse<Unit> {
        return deductedPointService.pointDeducted()
    }

    @ApiOperation(value = "금연 성공")
    @PostMapping
    fun successSmoking(): BaseResponse<Unit> {
        return successSmokingService.execute()
    }

    @ApiOperation(value = "금연 실패")
    @DeleteMapping
    fun failedSmoking(): BaseResponse<Unit> {
        return failedSmokingService.execute()
    }

}
