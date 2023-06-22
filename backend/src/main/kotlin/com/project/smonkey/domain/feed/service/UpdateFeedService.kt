package com.project.smonkey.domain.feed.service

import com.project.smonkey.domain.feed.exception.NotMyFeedException
import com.project.smonkey.domain.feed.facade.FeedFacade
import com.project.smonkey.domain.feed.mapper.toFeedType
import com.project.smonkey.domain.feed.payload.request.UpdateFeedRequest
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateFeedService(
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade
) {

    @Transactional
    fun updateFeed(
        feedId: Long,
        category: String,
        request: UpdateFeedRequest,
    ): BaseResponse<Unit> {
        val feed = feedFacade.getFeedById(feedId)
        val user = userFacade.getCurrentUser()

        if (feed.user != user) {
            throw NotMyFeedException
        }

        feed.update(
            title = request.title,
            content = request.content,
            category = category.toFeedType(),
        )

        return BaseResponse(
            status = 200,
            message = FEED_UPDATE_SUCCESS_MESSAGE,
            content = null,
        )
    }

    companion object {
        const val FEED_UPDATE_SUCCESS_MESSAGE = "success to update feed"
    }
}
