package com.project.smonkey.domain.feed.exception

import com.project.smonkey.domain.feed.exception.error.FeedErrorCode
import com.project.smonkey.global.exception.GlobalException

object NotMyFeedException : GlobalException(FeedErrorCode.NOT_MY_FEED) {
    val EXCEPTION = NotMyFeedException
}
