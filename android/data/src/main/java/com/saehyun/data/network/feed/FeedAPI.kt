package com.saehyun.data.network.feed

import com.saehyun.data.network.BaseResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface FeedAPI {

    @POST("/feed")
    suspend fun writeFeed(
        @Query("category") category: String
    ): BaseResponse<SimpleFeedResponse>

    @GET("/feed/{feed-id}")
    suspend fun detailFeed(
        @Query("feed-id") feedId: Int,
    ): BaseResponse<FeedResponse>

    @DELETE("/feed/{feed-id}")
    suspend fun deleteFeed(
        @Query("feed-id") feedId: Int,
    ): BaseResponse<Unit>

    @PATCH("/feed/{feed-id}/update")
    suspend fun updateFeed(
        @Path("feed-id") feedId: Int,
        @Query("category") category: String
    ): BaseResponse<SimpleFeedResponse>

    @GET("/feed/list")
    suspend fun getFeedList(): BaseResponse<FeedResponse>
}