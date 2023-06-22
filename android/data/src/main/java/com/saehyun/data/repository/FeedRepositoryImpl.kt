package com.saehyun.data.repository

import com.saehyun.data.network.feed.FeedAPI
import com.saehyun.data.network.feed.FeedListResponse
import com.saehyun.data.network.feed.FeedResponse
import com.saehyun.data.network.feed.SimpleFeedResponse
import com.saehyun.data.network.feed.WriteFeedRequest
import com.saehyun.data.util.FeedType
import javax.inject.Inject

class FeedRepositoryImpl @Inject constructor(
    private val feedAPI: FeedAPI
) : FeedRepository {
    override suspend fun writeFeed(
        request: WriteFeedRequest,
        category: FeedType
    ): SimpleFeedResponse {
        return feedAPI.writeFeed(
            request = request,
            category = category.toString(),
        ).content
    }

    override suspend fun detailFeed(feedId: Int): FeedResponse {
        return feedAPI.detailFeed(feedId = feedId).content
    }

    override suspend fun deleteFeed(feedId: Int) {
        return feedAPI.deleteFeed(feedId = feedId).content
    }

    override suspend fun updateFeed(feedId: Int, category: String): SimpleFeedResponse {
        return feedAPI.updateFeed(
            feedId = feedId,
            category = category,
        ).content
    }

    override suspend fun getFeedList(category: FeedType): FeedListResponse {
        return feedAPI.getFeedList(category.toString()).content
    }
}