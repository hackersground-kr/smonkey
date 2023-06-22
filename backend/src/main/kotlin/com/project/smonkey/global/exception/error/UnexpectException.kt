package com.project.smonkey.global.exception.error

import com.project.smonkey.global.exception.GlobalException

object UnexpectException : GlobalException(GlobalExceptionErrorCode.UNEXPECT) {
    val EXCEPTION = UnexpectException
}
