package com.saehyun.data.network.user

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @field:SerializedName("accountId")
    val accountId: String,
    @field:SerializedName("password")
    val password: String,
)
