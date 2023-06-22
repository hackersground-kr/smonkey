package com.saehyun.data.repository

import com.saehyun.data.network.smoking.SmokingAPI
import javax.inject.Inject

class SmokingRepositoryImpl @Inject constructor(
    private val smokingAPI: SmokingAPI,
) : SmokingRepository {
    override suspend fun successQuitSmoking() {
        smokingAPI.successQuitSmoking()
    }

    override suspend fun failedQuitSmoking() {
        smokingAPI.failedQuitSmoking()
    }
}