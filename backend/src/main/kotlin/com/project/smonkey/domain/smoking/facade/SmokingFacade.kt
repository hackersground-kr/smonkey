package com.project.smonkey.domain.smoking.facade

import com.project.smonkey.domain.smoking.entity.Smoking

interface SmokingFacade {

    fun getSmokingByUserId(
        userId: Long,
    ): Smoking

    fun saveSmoking(
        smoking: Smoking,
    )
}
