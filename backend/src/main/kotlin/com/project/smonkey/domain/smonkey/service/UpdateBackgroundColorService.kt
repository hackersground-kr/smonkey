package com.project.smonkey.domain.smonkey.service

import com.project.smonkey.domain.smonkey.entity.SMonkey
import com.project.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.project.smonkey.domain.smonkey.payload.request.UpdateBackgroundColorRequest
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateBackgroundColorService(
    private val smonkeyFacade: SMonkeyFacade,
    private val userFacade: UserFacade,
) {

    @Transactional
    fun updateBackgroundColorService(
        request: UpdateBackgroundColorRequest
    ): BaseResponse<Unit> {
        val user = userFacade.getCurrentUser()

        val smonkey: SMonkey = smonkeyFacade.getSMonkeyById(
            userId = user.id,
        )

        smonkey.updateColor(
            backgroundColor = request.backgroundColor,
        )

        return BaseResponse(
            status = 201,
            message = "success to change",
            content = null,
        )
    }
}
