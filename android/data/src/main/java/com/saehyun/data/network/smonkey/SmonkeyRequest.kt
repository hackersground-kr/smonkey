package com.saehyun.data.network.smonkey

import com.google.gson.annotations.SerializedName

data class SmonkeyRequest(
    @field:SerializedName("backgroundColor")
    val backgroundColor: String,
    @field:SerializedName("name")
    val name: String,
)
