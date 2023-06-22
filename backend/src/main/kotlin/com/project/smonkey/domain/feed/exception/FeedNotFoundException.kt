package com.project.smonkey.domain.feed.exception

import com.project.smonkey.domain.feed.exception.error.FeedErrorCode
import com.project.smonkey.global.exception.GlobalException

object FeedNotFoundException : GlobalException(FeedErrorCode.POST_NOT_FOUND) {
    val EXCEPTION = FeedNotFoundException
}
