package com.project.smonkey.global.security.exception

import com.project.smonkey.global.exception.error.ErrorResponse

/**
 * JWT의 ErrorCode를 가지고 있는 Enum [TokenErrorCode]
 *
 * @param status http status code
 * @param message exception message
 */
enum class TokenErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorResponse {

    /**
     * 토큰이 만료되었을 경우
     */
    TOKEN_EXPIRED(401, "Token Expired"),
    /**
     * JWT 토큰의 시그니쳐가 손상되었을 경우
     */
    TOKEN_SIGNATURE(401, "Invalid Signature"),
    /**
     * 토큰이 검증에 실패했을 경우
     */
    TOKEN_VALIDATE_FAIL(401, "Token Validate Failed"),
    /**
     * 토큰 검증 과정에서 예상치 못한 오류가 발생했을 경우
     */
    TOKEN_UNEXPECTED(401, "Unexpected Token Exception"),
}
