package com.saehyun.data.repository

import com.saehyun.data.network.BaseResponse

interface SmokingRepository {
    suspend fun successQuitSmoking()
    suspend fun failedQuitSmoking()
}