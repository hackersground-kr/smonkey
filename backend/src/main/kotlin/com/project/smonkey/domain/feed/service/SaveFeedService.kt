package com.project.smonkey.domain.feed.service

import com.project.smonkey.domain.feed.entity.Feed
import com.project.smonkey.domain.feed.facade.FeedFacade
import com.project.smonkey.domain.feed.mapper.toFeedType
import com.project.smonkey.domain.feed.payload.request.SaveFeedRequest
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class SaveFeedService(
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade,
) {

    fun saveFeed(
        category: String,
        request: SaveFeedRequest
    ): BaseResponse<Unit> {
        val user = userFacade.getCurrentUser()

        feedFacade.saveFeed(
            Feed(
                user = user,
                title = request.title,
                content = request.content,
                category = category.toFeedType()
            )
        )

        return BaseResponse(
            status = 201,
            message = SaveFeedSuccessMessage,
            content = null,
        )
    }

    companion object {
        const val SaveFeedSuccessMessage = "success to save feed"
    }
}
