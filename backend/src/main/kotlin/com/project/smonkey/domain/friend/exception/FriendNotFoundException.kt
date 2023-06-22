package com.project.smonkey.domain.friend.exception

import com.project.smonkey.domain.friend.exception.error.FriendErrorCode
import com.project.smonkey.global.exception.GlobalException

object FriendNotFoundException : GlobalException(FriendErrorCode.FRIEND_NOT_FOUND) {
    val EXCEPTION = FriendNotFoundException
}
