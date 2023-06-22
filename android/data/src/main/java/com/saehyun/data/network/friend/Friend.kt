package com.saehyun.data.network.friend

import com.google.gson.annotations.SerializedName

data class Friend(
    @field:SerializedName("backgroundColor")
    val backgroundColor: String,
    @field:SerializedName("friendId")
    val friendId: Int,
    @field:SerializedName("level")
    val level: Int,
    @field:SerializedName("nextPoint")
    val nextPoint: Int,
    @field:SerializedName("point")
    val point: Int,
    @field:SerializedName("smonkeyName")
    val smonkeyName: String,
    @field:SerializedName("step")
    val step: Int,
    @field:SerializedName("userName")
    val userName: String,
)
