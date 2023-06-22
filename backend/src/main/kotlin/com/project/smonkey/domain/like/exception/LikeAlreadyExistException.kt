package com.project.smonkey.domain.like.exception

import com.project.smonkey.domain.like.exception.error.LikeErrorCode
import com.project.smonkey.global.exception.GlobalException

object LikeAlreadyExistException : GlobalException(LikeErrorCode.LIKE_ALREADY_EXIST) {
    val EXCEPTION = LikeAlreadyExistException
}
