package com.saehyun.data.network.smoking

import com.saehyun.data.network.BaseResponse
import retrofit2.http.DELETE
import retrofit2.http.POST

interface SmokingAPI {

    @POST("/smoking")
    suspend fun successQuitSmoking(): BaseResponse<Unit>

    @DELETE("/smoking")
    suspend fun failedQuitSmoking(): BaseResponse<Unit>
}