package com.saehyun.data.repository

import com.saehyun.data.network.feed.FeedListResponse
import com.saehyun.data.network.feed.FeedResponse
import com.saehyun.data.network.feed.SimpleFeedResponse
import com.saehyun.data.network.feed.WriteFeedRequest
import com.saehyun.data.util.FeedType

interface FeedRepository {
    suspend fun writeFeed(request: WriteFeedRequest, category: FeedType): SimpleFeedResponse

    suspend fun detailFeed(feedId: Int): FeedResponse

    suspend fun deleteFeed(feedId: Int)


    suspend fun updateFeed(
        feedId: Int,
        category: String,
    ): SimpleFeedResponse

    suspend fun getFeedList(category: FeedType): FeedListResponse
}