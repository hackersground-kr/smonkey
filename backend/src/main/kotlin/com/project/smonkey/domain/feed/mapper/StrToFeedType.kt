package com.project.smonkey.domain.feed.mapper

import com.project.smonkey.domain.feed.enum.FeedType
import com.project.smonkey.domain.feed.exception.FeedTypeNotExistException

internal fun String.toFeedType(): FeedType {

    for (feedType in FeedType.values()) {
        if (feedType.toString() == this) return feedType
    }

    throw FeedTypeNotExistException
}
