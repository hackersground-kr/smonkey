package com.saehyun.data.network.like

import com.saehyun.data.network.BaseResponse
import retrofit2.http.DELETE
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface LikeAPI {

    @POST("/like/{feed-id}")
    suspend fun likeFeed(
        @Path("feed-id") feedId: Int,
    ): BaseResponse<Unit>

    @DELETE("/like/{feed-id}")
    suspend fun dislikeFeed(
        @Path("feed-id") feedId: Int,
    ): BaseResponse<Unit>
}