package com.project.smonkey.domain.smoking.exception

import com.project.smonkey.domain.smoking.exception.error.SmokingErrorCode
import com.project.smonkey.global.exception.GlobalException

object SmokingAlreadyExistException : GlobalException(SmokingErrorCode.SMOKING_ALREADY_EXIST) {
    val EXCEPTION = SmokingAlreadyExistException
}
