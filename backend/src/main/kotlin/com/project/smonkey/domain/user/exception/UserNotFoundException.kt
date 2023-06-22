package com.project.smonkey.domain.user.exception

import com.project.smonkey.domain.user.exception.error.UserErrorCode
import com.project.smonkey.global.exception.GlobalException

/**
 * 유저가 존재하지 않을 경우의 [Exception]
 *
 * @throws UserNotFoundException
 */
object UserNotFoundException : GlobalException(UserErrorCode.USER_NOT_FOUND) {
    val EXCEPTION = UserNotFoundException
}
