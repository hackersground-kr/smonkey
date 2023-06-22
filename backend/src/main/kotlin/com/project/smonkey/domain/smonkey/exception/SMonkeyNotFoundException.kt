package com.project.smonkey.domain.smonkey.exception

import com.project.smonkey.domain.smonkey.exception.error.SMonkeyErrorCode
import com.project.smonkey.global.exception.GlobalException

object SMonkeyNotFoundException : GlobalException(SMonkeyErrorCode.SMONKEY_NOT_FOUND) {
    val EXCEPTION = SMonkeyNotFoundException
}
