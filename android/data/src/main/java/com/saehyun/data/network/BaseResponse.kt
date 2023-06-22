package com.saehyun.data.network

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @field:SerializedName("content")
    val content: T,
    @field:SerializedName("message")
    val message: String,
    @field:SerializedName("status")
    val status: Int,
)