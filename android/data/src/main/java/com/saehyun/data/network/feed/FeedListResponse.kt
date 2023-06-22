package com.saehyun.data.network.feed

import com.google.gson.annotations.SerializedName

data class FeedListResponse(
    @field:SerializedName("feedList")
    val feedList: List<FeedResponse>
)
