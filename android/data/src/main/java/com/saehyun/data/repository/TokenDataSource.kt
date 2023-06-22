package com.saehyun.data.repository

import kotlinx.coroutines.flow.Flow

interface TokenDataSource {
   suspend  fun getToken(): Flow<String>

   suspend fun saveToken(accessToken: String, refreshToken: String)
}