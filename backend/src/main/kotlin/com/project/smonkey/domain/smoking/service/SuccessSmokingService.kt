package com.project.smonkey.domain.smoking.service

import com.project.smonkey.domain.smonkey.exception.SMonkeyNotFoundException
import com.project.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import javax.transaction.Transactional

@Service
class SuccessSmokingService(
    private val userFacade: UserFacade,
    private val sMonkeyFacade: SMonkeyFacade,
) {

    @Transactional
    fun execute(): BaseResponse<Unit> {
        val user = userFacade.getCurrentUser()

        if (!sMonkeyFacade.getSMonkeyExist(user.id)) {
            throw SMonkeyNotFoundException
        }

        val sMonkey = sMonkeyFacade.getSMonkeyById(user.id)

        val price = ((user.price) / (user.cigaretteAmount)) * user.amount
        sMonkey.addSavePrice(price)

        val now = LocalDateTime.now()
        sMonkey.updateNoSmokingDate((now.hour * 3600) + (now.minute * 60) + now.second)

        return BaseResponse(
            status = 200,
            message = "success no smoking",
            content = null
        )
    }

}
