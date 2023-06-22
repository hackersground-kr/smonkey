package com.saehyun.data.repository

import com.saehyun.data.network.BaseResponse
import com.saehyun.data.network.smonkey.BackgroundColorRequest
import com.saehyun.data.network.smonkey.SMonkeyAPI
import com.saehyun.data.network.smonkey.SmonkeyRequest
import com.saehyun.data.network.smonkey.SmonkeyResponse
import javax.inject.Inject

class SmonkeyRepositoryImpl @Inject constructor(
    private val smonkeyAPI: SMonkeyAPI
) : SmonkeyRepository {
    override suspend fun getSmonkey(): BaseResponse<SmonkeyResponse> {
        return smonkeyAPI.getSmonkey()
    }

    override suspend fun createSmonkey(request: SmonkeyRequest): BaseResponse<Unit> {
        return smonkeyAPI.createSmonkey(request)
    }

    override suspend fun changeBackgroundColor(request: BackgroundColorRequest): BaseResponse<Unit> {
        return smonkeyAPI.changeBackgroundColor(request)
    }
}