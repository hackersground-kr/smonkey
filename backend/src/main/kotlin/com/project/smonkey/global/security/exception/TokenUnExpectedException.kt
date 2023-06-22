package com.project.smonkey.global.security.exception

import com.project.smonkey.global.exception.GlobalException

/**
 * JWT의 예상치 못한 오류가 발생했을 경우의 Exception
 *
 * @throws TokenUnExpectedException
 */
object TokenUnExpectedException : GlobalException(TokenErrorCode.TOKEN_UNEXPECTED) {
    val EXCEPTION = TokenUnExpectedException
}
