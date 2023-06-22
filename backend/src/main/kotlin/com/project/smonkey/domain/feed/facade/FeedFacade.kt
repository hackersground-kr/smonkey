package com.project.smonkey.domain.feed.facade

import com.project.smonkey.domain.feed.entity.Feed

interface FeedFacade {

    fun getFeedById(feedId: Long): Feed

    fun getFeedAll(): List<Feed>

    fun saveFeed(feed: Feed)

    fun deleteFeedById(feed: Feed)
}
