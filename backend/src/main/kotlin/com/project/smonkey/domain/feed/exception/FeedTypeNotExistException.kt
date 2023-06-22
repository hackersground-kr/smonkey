package com.project.smonkey.domain.feed.exception

import com.project.smonkey.domain.feed.exception.error.FeedErrorCode
import com.project.smonkey.global.exception.GlobalException

object FeedTypeNotExistException : GlobalException(FeedErrorCode.FEED_TYPE_NOT_EXIST) {
    val EXCEPTION = FeedTypeNotExistException
}
