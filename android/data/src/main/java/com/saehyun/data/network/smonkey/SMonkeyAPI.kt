package com.saehyun.data.network.smonkey

import com.saehyun.data.network.BaseResponse
import com.saehyun.data.network.smonkey.BackgroundColorRequest
import com.saehyun.data.network.smonkey.SmonkeyRequest
import com.saehyun.data.network.smonkey.SmonkeyResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface SMonkeyAPI {

    @GET("/smonkey")
    suspend fun getSmonkey(): BaseResponse<SmonkeyResponse>

    @POST("/smonkey")
    suspend fun createSmonkey(
        @Body request: SmonkeyRequest,
    ): BaseResponse<Unit>

    @PATCH("/smonkey")
    suspend fun changeBackgroundColor(
        @Body request: BackgroundColorRequest,
    ): BaseResponse<Unit>
}