package com.project.smonkey.global.exception.error

import com.project.smonkey.global.exception.GlobalException

object InvalidMethodArgumentException : GlobalException(GlobalExceptionErrorCode.INVALID_METHOD_ARGUMENT) {
    val EXCEPTION = InvalidMethodArgumentException
}
