package com.project.smonkey.domain.like.facade

import com.project.smonkey.domain.feed.entity.Feed
import com.project.smonkey.domain.like.entity.FeedLike

interface LikeFacade {

    fun checkLikeAlready(
        userId: Long,
        feedId: Long,
    ): Boolean

    fun getLikeCount(feed: Feed): Int

    fun like(feedLike: FeedLike)

    fun disLike(feedLike: FeedLike)
}
