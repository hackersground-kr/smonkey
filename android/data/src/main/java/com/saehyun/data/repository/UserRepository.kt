package com.saehyun.data.repository

import com.saehyun.data.network.user.SignInRequest
import com.saehyun.data.network.user.SignUpRequest

interface UserRepository {
    suspend fun signIn(request: SignInRequest)
    suspend fun signUp(request: SignUpRequest)
}