package com.saehyun.data.network.user

import com.google.gson.annotations.SerializedName

data class TokenResponse(
    @field:SerializedName("accessToken")
    val accessToken: String,
    @field:SerializedName("refreshToken")
    val refreshToken: String,
)

