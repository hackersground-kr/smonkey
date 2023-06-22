package com.project.smonkey.domain.feed.facade

import com.project.smonkey.domain.feed.entity.Feed
import com.project.smonkey.domain.feed.exception.FeedNotFoundException
import com.project.smonkey.domain.feed.repository.FeedRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class FeedFacadeImpl(
    private val feedRepository: FeedRepository,
) : FeedFacade {

    override fun getFeedById(feedId: Long): Feed {
        return feedRepository.findByIdOrNull(feedId) ?: throw FeedNotFoundException
    }

    override fun getFeedAll(): List<Feed> {
        return feedRepository.findAll()
    }

    override fun saveFeed(feed: Feed) {
        feedRepository.save(feed)
    }

    override fun deleteFeedById(feed: Feed) {
        feedRepository.delete(feed)
    }
}
