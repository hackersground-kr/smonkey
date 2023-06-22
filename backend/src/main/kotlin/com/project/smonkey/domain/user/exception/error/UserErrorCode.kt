package com.project.smonkey.domain.user.exception.error

import com.project.smonkey.global.exception.error.ErrorResponse

/**
 * User와 관련된 Error를 가지고 있는 Enum
 *
 * @param status http status code
 * @param message exception message
 */
enum class UserErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorResponse {

    /**
     * 유저를 찾을 수 없는 경우
     */
    USER_NOT_FOUND(
        status = 404,
        message = "user not found",
    ),

    /**
     * 비밀번호가 올바르지 않은 경우
     */
    PASSWORD_NOT_CORRECT(
        status = 401,
        message = "password not correct",
    ),

    /**
     * 이미 유저가 존재 할 경우
     */
    USER_ALREADY_EXIST(
        status = 409,
        message = "user already exist",
    )
}
