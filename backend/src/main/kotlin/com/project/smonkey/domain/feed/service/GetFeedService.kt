package com.project.smonkey.domain.feed.service

import com.project.smonkey.domain.feed.enum.FeedType
import com.project.smonkey.domain.feed.facade.FeedFacade
import com.project.smonkey.domain.feed.mapper.toFeedType
import com.project.smonkey.domain.feed.payload.response.GetFeedListResponse
import com.project.smonkey.domain.feed.payload.response.GetFeedResponse
import com.project.smonkey.domain.like.facade.LikeFacade
import com.project.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.project.smonkey.domain.smonkey.mapper.levelToNextMaxPoint
import com.project.smonkey.domain.smonkey.mapper.pointToCurrentPoint
import com.project.smonkey.domain.smonkey.mapper.toLevel
import com.project.smonkey.domain.smonkey.mapper.toStep
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.extension.runIf
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

/**
 * [TODO]
 * 댓글 기능 완성 후 도입 필요
 */
@Service
class GetFeedService(
    private val feedFacade: FeedFacade,
    private val smonkeyFacade: SMonkeyFacade,
    private val userFacade: UserFacade,
    private val likeFacade: LikeFacade,
) {

    fun getFeed(
        feedId: Long,
    ): BaseResponse<GetFeedResponse> {

        val feed = feedFacade.getFeedById(
            feedId = feedId,
        )

        val userId = feed.user.id

        val user = userFacade.getById(
            id = userId,
        )

        val smonkey = smonkeyFacade.getSMonkeyById(
            userId = userId,
        )

        val likeCount = likeFacade.getLikeCount(feed)
        val isLike = likeFacade.checkLikeAlready(
            userId = user.id,
            feedId = feed.id,
        )

        val level = smonkey.point.toLevel()

        return BaseResponse(
            status = 200,
            message = GET_FEED_SUCCESS_MESSAGE,
            content = GetFeedResponse(
                writer = GetFeedResponse.Writer(
                    userName = user.name,
                    smonkeyName = smonkey.name,
                    backgroundColor = smonkey.backgroundColor,
                    step = level.toStep(),
                    point = smonkey.point.pointToCurrentPoint(),
                    level = level,
                    nextPoint = level.levelToNextMaxPoint(),
                ),
                feedId = feed.id,
                title = feed.title,
                content = feed.content,
                likeCount = likeCount,
                isLike = isLike,
                category = feed.category,
                createdAt = feed.createdAt!!,
            )
        )
    }

    fun getFeedList(
        category: String,
    ): BaseResponse<GetFeedListResponse> {

        val feedType = category.toFeedType()

        val feedList = feedFacade
            .getFeedAll()
            .runIf(feedType != FeedType.ALL) {
                filter {
                    it.category == feedType
                }
            }

        val response =
            GetFeedListResponse(
                feedList = feedList.map {
                    val feed = feedFacade.getFeedById(it.id)
                    val user = userFacade.getById(feed.user.id)
                    val smonkey = smonkeyFacade.getSMonkeyById(feed.user.id)

                    val level = smonkey.point.toLevel()

                    val likeCount = likeFacade.getLikeCount(feed)
                    val isLike = likeFacade.checkLikeAlready(
                        userId = user.id,
                        feedId = feed.id,
                    )

                    GetFeedListResponse.Feed(
                        writer = GetFeedListResponse.Feed.Writer(
                            userName = user.name,
                            smonkeyName = smonkey.name,
                            backgroundColor = smonkey.backgroundColor,
                            step = level.toStep(),
                            point = smonkey.point,
                            level = level,
                            nextPoint = level.levelToNextMaxPoint(),
                        ),
                        feedId = feed.id,
                        title = feed.title,
                        content = feed.content,
                        likeCount = likeCount,
                        isLike = isLike,
                        category = feed.category,
                        createdAt = feed.createdAt!!,
                    )
                }
            )

        return BaseResponse(
            status = 200,
            message = GET_FEED_LIST_SUCCESS_MESSAGE,
            content = response,
        )
    }

    companion object {
        const val GET_FEED_SUCCESS_MESSAGE = "success to get feed"
        const val GET_FEED_LIST_SUCCESS_MESSAGE = "success to get feeds"
    }
}
