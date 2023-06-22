package com.project.smonkey.domain.smonkey.controller

import com.project.smonkey.domain.smonkey.payload.request.MakeSMonkeyRequest
import com.project.smonkey.domain.smonkey.payload.request.UpdateBackgroundColorRequest
import com.project.smonkey.domain.smonkey.payload.response.GetSMonkeyResponse
import com.project.smonkey.domain.smonkey.service.GetSMonkeyService
import com.project.smonkey.domain.smonkey.service.MakeSMonkeyService
import com.project.smonkey.domain.smonkey.service.UpdateBackgroundColorService
import com.project.smonkey.global.payload.BaseResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Api(tags = ["캐릭터 API"], description = "캐릭터 API")
@RequestMapping("/smonkey")
@RestController
class SMonkeyController(
    private val makeSMonkeyService: MakeSMonkeyService,
    private val updateBackgroundColorService: UpdateBackgroundColorService,
    private val getSMonkeyService: GetSMonkeyService,
) {

    @ApiOperation(value = "스몽키 만들기")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun makeSMonkey(
        @RequestBody request: MakeSMonkeyRequest,
    ): BaseResponse<Unit> {
        return makeSMonkeyService.makeSMonkey(
            request = request,
        )
    }

    @ApiOperation(value = "스몽키 배경색상 변경")
    @PatchMapping
    fun updateBackgroundColor(
        @RequestBody request: UpdateBackgroundColorRequest,
    ): BaseResponse<Unit> {
        return updateBackgroundColorService.updateBackgroundColorService(
            request = request,
        )
    }

    @ApiOperation(value = "내 스몽키 조회")
    @GetMapping
    fun getSMonkey(): BaseResponse<GetSMonkeyResponse> {
        return getSMonkeyService.getMonkey()
    }
}
