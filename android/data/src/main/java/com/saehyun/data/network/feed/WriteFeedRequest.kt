package com.saehyun.data.network.feed

import com.google.gson.annotations.SerializedName

data class WriteFeedRequest(
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("content")
    val content: String,
)
