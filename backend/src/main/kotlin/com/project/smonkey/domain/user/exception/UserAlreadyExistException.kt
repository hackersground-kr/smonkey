package com.project.smonkey.domain.user.exception

import com.project.smonkey.domain.user.exception.error.UserErrorCode
import com.project.smonkey.global.exception.GlobalException

/**
 * 유저가 이미 존재할 때 발생하는 [Exception]
 *
 * @throws UserAlreadyExistException
 */
object UserAlreadyExistException : GlobalException(UserErrorCode.USER_ALREADY_EXIST) {
    val EXCEPTION = UserAlreadyExistException
}
