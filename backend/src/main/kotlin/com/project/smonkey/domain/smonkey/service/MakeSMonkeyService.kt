package com.project.smonkey.domain.smonkey.service

import com.project.smonkey.domain.smonkey.entity.SMonkey
import com.project.smonkey.domain.smonkey.exception.ColorNotFoundException
import com.project.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.project.smonkey.domain.smonkey.payload.request.MakeSMonkeyRequest
import com.project.smonkey.domain.smonkey.utils.DefaultPoint
import com.project.smonkey.domain.smonkey.utils.colorList
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class MakeSMonkeyService(
    private val sMonkeyFacade: SMonkeyFacade,
    private val userFacade: UserFacade,
) {

    fun makeSMonkey(
        request: MakeSMonkeyRequest
    ): BaseResponse<Unit> {
        val user = userFacade.getCurrentUser()

        if (
            colorList.none {
                it == request.backgroundColor
            }
        ) {
            throw ColorNotFoundException.EXCEPTION
        }

        sMonkeyFacade.saveSMonkey(
            SMonkey(
                userId = user.id,
                name = request.name,
                backgroundColor = request.backgroundColor,
                point = DefaultPoint,
                savePrice = 0,
                spendPrice = 0,
                noSmokingDate = 0,
                smokingDate = 0,
            )
        )

        return BaseResponse(
            status = 201,
            message = "success to make smonkey",
            content = null,
        )
    }
}
