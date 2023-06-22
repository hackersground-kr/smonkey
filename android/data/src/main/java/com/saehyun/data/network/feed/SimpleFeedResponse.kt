package com.saehyun.data.network.feed

import com.google.gson.annotations.SerializedName

data class SimpleFeedResponse(
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("title")
    val title: String,
)
