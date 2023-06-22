package com.project.smonkey.domain.like.facade

import com.project.smonkey.domain.like.entity.FeedLike
import com.project.smonkey.domain.like.exception.LikeAlreadyExistException
import com.project.smonkey.domain.like.exception.LikeNotFoundException
import com.project.smonkey.domain.like.repository.LikeRepository
import org.springframework.stereotype.Component

@Component
class LikeFacadeImpl(
    private val likeRepository: LikeRepository,
) : LikeFacade {

    override fun checkLikeAlready(
        userId: Long,
        feedId: Long,
    ): Boolean {
        val feed = likeRepository.findByFeedIdAndUserId(
            userId = userId,
            feedId = feedId,
        )

        return feed != null
    }

    override fun getLikeCount(feed: com.project.smonkey.domain.feed.entity.Feed): Int {
        return likeRepository.findByFeedId(feed.id)?.size ?: 0
    }

    override fun like(feedLike: FeedLike) {
        val like: FeedLike? = likeRepository.findByFeedIdAndUserId(
            feedId = feedLike.feed.id,
            userId = feedLike.user.id,
        )

        if (like == null) {
            likeRepository.save(feedLike)
        } else {
            throw LikeAlreadyExistException
        }
    }

    override fun disLike(feedLike: FeedLike) {
        val like: FeedLike? = likeRepository.findByFeedIdAndUserId(
            feedId = feedLike.feed.id,
            userId = feedLike.user.id,
        )

        if (like != null) {
            likeRepository.deleteById(like.id)
        } else {
            throw LikeNotFoundException
        }
    }
}
