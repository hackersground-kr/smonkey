package com.saehyun.data.network.smonkey

import com.google.gson.annotations.SerializedName

data class BackgroundColorRequest(
    @field:SerializedName("backgroundColor")
    val backgroundColor: String,
)
