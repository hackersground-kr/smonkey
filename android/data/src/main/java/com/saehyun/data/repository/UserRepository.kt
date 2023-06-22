package com.saehyun.data.repository

import com.saehyun.data.network.user.SignInRequest
import com.saehyun.data.network.user.SignUpRequest
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun signIn(request: SignInRequest)
    suspend fun signUp(request: SignUpRequest)

    suspend fun getToken(): Flow<String>
}