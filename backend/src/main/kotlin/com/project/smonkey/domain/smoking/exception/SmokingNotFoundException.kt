package com.project.smonkey.domain.smoking.exception

import com.project.smonkey.domain.smoking.exception.error.SmokingErrorCode
import com.project.smonkey.global.exception.GlobalException

object SmokingNotFoundException : GlobalException(SmokingErrorCode.SMOKING_NOT_FOUND) {
    val EXCEPTION = SmokingNotFoundException
}
