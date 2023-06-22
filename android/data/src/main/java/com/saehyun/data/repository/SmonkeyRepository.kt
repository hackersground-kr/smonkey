package com.saehyun.data.repository

import com.saehyun.data.network.BaseResponse
import com.saehyun.data.network.smonkey.BackgroundColorRequest
import com.saehyun.data.network.smonkey.SmonkeyRequest
import com.saehyun.data.network.smonkey.SmonkeyResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST

interface SmonkeyRepository {

    suspend fun getSmonkey(): BaseResponse<SmonkeyResponse>

    suspend fun createSmonkey(
        request: SmonkeyRequest,
    ): BaseResponse<Unit>

    suspend fun changeBackgroundColor(
        request: BackgroundColorRequest,
    ): BaseResponse<Unit>
}