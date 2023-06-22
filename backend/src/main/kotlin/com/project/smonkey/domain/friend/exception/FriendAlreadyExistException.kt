package com.project.smonkey.domain.friend.exception

import com.project.smonkey.domain.friend.exception.error.FriendErrorCode
import com.project.smonkey.global.exception.GlobalException

object FriendAlreadyExistException : GlobalException(FriendErrorCode.FRIEND_ALREADY_EXIST) {
    val EXCEPTION = FriendAlreadyExistException
}
