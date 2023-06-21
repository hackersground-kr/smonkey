package com.saehyun.data.network.user

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @field:SerializedName("accountId")
    val accountId: String,
    @field:SerializedName("age")
    val age : Int,
    @field:SerializedName("email")
    val email: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("password")
    val password: String,
)
