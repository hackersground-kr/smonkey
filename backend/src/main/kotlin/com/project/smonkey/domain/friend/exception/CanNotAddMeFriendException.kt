package com.project.smonkey.domain.friend.exception

import com.project.smonkey.domain.friend.exception.error.FriendErrorCode
import com.project.smonkey.global.exception.GlobalException

object CanNotAddMeFriendException : GlobalException(FriendErrorCode.CAN_NOT_ADD_ME_FRIEND) {
    val EXCEPTION = CanNotAddMeFriendException
}
