package com.project.smonkey.domain.feed.service

import com.project.smonkey.domain.feed.exception.NotMyFeedException
import com.project.smonkey.domain.feed.facade.FeedFacade
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class DeleteFeedService(
    private val userFacade: UserFacade,
    private val feedFacade: FeedFacade,
) {

    fun deleteFeed(
        feedId: Long,
    ): BaseResponse<Unit> {
        val user = userFacade.getCurrentUser()
        val feed = feedFacade.getFeedById(feedId)

        if (feed.user.id != user.id) {
            throw NotMyFeedException.EXCEPTION
        }

        feedFacade.deleteFeedById(feed)

        return BaseResponse(
            status = 200,
            message = DELETE_FEED_SUCCESS_MESSAGE,
            content = null,
        )
    }

    companion object {
        const val DELETE_FEED_SUCCESS_MESSAGE = "success to delete feed"
    }
}
