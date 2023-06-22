package com.saehyun.data.network.friend

import com.google.gson.annotations.SerializedName

data class FriendResponse(
    @field:SerializedName("friendList")
    val friendList: List<Friend>,
)
