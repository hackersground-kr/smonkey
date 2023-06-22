package com.saehyun.data.network.user

import com.saehyun.data.network.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAPI {

    @POST("/user")
    suspend fun signUp(
        @Body request: SignUpRequest,
    ): BaseResponse<TokenResponse>

    @POST("/user/signin")
    suspend fun signIn(
        @Body request: SignInRequest,
    ): BaseResponse<TokenResponse>
}