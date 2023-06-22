package com.project.smonkey.domain.smonkey.exception

import com.project.smonkey.domain.smonkey.exception.error.SMonkeyErrorCode
import com.project.smonkey.global.exception.GlobalException

object SmokingStepNotFoundException : GlobalException(SMonkeyErrorCode.SMOKING_STEP_NOT_FOUND) {
    val EXCEPTION = SmokingStepNotFoundException
}
