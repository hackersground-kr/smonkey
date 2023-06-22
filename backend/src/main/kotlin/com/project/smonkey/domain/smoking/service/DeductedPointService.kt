package com.project.smonkey.domain.smoking.service

import com.project.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

/**
 * 기본적으로 차감되는 포인트
 */
private const val DeductedPoint: Int = 240

@Service
class DeductedPointService(
    private val smonkeyFacade: SMonkeyFacade,
    private val userFacade: UserFacade,
) {

    @Transactional
    fun pointDeducted(): BaseResponse<Unit> {
        val user = userFacade.getCurrentUser()
        val smonkey = smonkeyFacade.getSMonkeyById(
            userId = user.id
        )

        smonkey.updatePoint(
            point = smonkey.point - DeductedPoint
        )

        return BaseResponse(
            status = 201,
            message = "success to deducted point",
            content = null,
        )
    }
}
