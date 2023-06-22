package com.saehyun.data.repository

import com.saehyun.data.network.feed.FeedResponse
import com.saehyun.data.network.feed.SimpleFeedResponse
import com.saehyun.data.network.feed.WriteJournalRequest

interface FeedRepository {
    suspend fun writeFeed(request: WriteJournalRequest, category: String): SimpleFeedResponse

    suspend fun detailFeed(feedId: Int): FeedResponse

    suspend fun deleteFeed(feedId: Int)


    suspend fun updateFeed(
        feedId: Int,
        category: String,
    ): SimpleFeedResponse

    suspend fun getFeedList(): List<FeedResponse>
}