package com.project.smonkey.global.security.exception

import com.project.smonkey.global.exception.GlobalException

/**
 * 토큰 시그니쳐가 손상됐을 경우의 Exception
 *
 * @exception TokenSignatureException
 */
object TokenSignatureException : GlobalException(TokenErrorCode.TOKEN_SIGNATURE) {
    val EXCEPTION = TokenSignatureException
}
