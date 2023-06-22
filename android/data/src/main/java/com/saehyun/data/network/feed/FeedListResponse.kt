package com.saehyun.data.network.feed

import com.google.gson.annotations.SerializedName
import kotlinx.collections.immutable.ImmutableList

data class FeedListResponse(
    @field:SerializedName("feedList")
    val feedList: ImmutableList<FeedResponse>
)
