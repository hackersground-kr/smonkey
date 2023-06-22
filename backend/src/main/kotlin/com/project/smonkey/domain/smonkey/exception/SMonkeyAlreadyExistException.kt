package com.project.smonkey.domain.smonkey.exception

import com.project.smonkey.domain.smonkey.exception.error.SMonkeyErrorCode
import com.project.smonkey.global.exception.GlobalException

/**
 * 스몽키가 이미 존재 할 경우
 *
 * @throws SMonkeyAlreadyExistException
 */
object SMonkeyAlreadyExistException : GlobalException(SMonkeyErrorCode.SMONKEY_ALREADY_EXIST) {
    val EXCEPTION = SMonkeyAlreadyExistException
}
