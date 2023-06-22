package com.saehyun.data.network.friend

import com.google.gson.annotations.SerializedName

data class FriendSearchResponse(
    @field:SerializedName("userList")
    val userList: List<Friend>,
)
