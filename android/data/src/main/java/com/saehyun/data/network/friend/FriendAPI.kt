package com.saehyun.data.network.friend

import com.saehyun.data.network.BaseResponse
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface FriendAPI {

    @GET("/friend")
    suspend fun getFriend(): BaseResponse<FriendResponse>

    @POST("/friend")
    suspend fun addFriend(
        @Query("account-id") accountId: Int,
    ): BaseResponse<Unit>

    @POST("/friend/accept")
    suspend fun acceptFriend(
        @Query("friend-id") friendId: Int,
    ): BaseResponse<Unit>

    @POST("/friend/refuse")
    suspend fun refuseFriend(
        @Query("friend-id") friendId: Int,
    ): BaseResponse<Unit>

    @GET("/friend/request")
    suspend fun getFriendRequest(): BaseResponse<FriendResponse>

    @GET("/friend/search")
    suspend fun searchFriend(
        @Query("name") name: String,
    ): BaseResponse<FriendSearchResponse>
}