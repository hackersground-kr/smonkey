package com.saehyun.data.network.feed

import com.google.gson.annotations.SerializedName

data class FeedResponse(
    @field:SerializedName("category")
    val category: String,
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("createdAt")
    val createdAt: String,
    @field:SerializedName("isLike")
    val isLike: Boolean,
    @field:SerializedName("likeCount")
    val likeCount: Int,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("writer")
    val writer: Writer,
)
