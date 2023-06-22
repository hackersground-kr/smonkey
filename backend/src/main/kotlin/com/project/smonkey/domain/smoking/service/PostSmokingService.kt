package com.project.smonkey.domain.smoking.service

import com.project.smonkey.domain.smoking.entity.Smoking
import com.project.smonkey.domain.smoking.facade.SmokingFacade
import com.project.smonkey.domain.smoking.payload.request.PostSmokingRequest
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class PostSmokingService(
    private val userFacade: UserFacade,
    private val smokingFacade: SmokingFacade,
) {

    fun postSmoking(
        request: PostSmokingRequest,
    ): BaseResponse<Unit> {

        val user = userFacade.getCurrentUser()

        smokingFacade.saveSmoking(
            smoking = Smoking(
                userId = user.id,
                average = request.average,
                price = request.price,
                startAt = request.startAt,
                endAt = request.endAt,
            )
        )

        return BaseResponse(
            status = 201,
            message = POST_SMOKING_SUCCESS_MESSAGE,
            content = null,
        )
    }

    companion object {
        const val POST_SMOKING_SUCCESS_MESSAGE = "success to post smoking info"
    }
}
