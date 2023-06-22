package com.project.smonkey.domain.like.exception

import com.project.smonkey.domain.like.exception.error.LikeErrorCode
import com.project.smonkey.global.exception.GlobalException

object LikeNotFoundException : GlobalException(LikeErrorCode.LIKE_NOT_FOUND) {
    val EXCEPTION = LikeNotFoundException
}
