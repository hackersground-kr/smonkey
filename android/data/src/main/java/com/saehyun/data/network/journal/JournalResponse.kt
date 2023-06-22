package com.saehyun.data.network.journal

import com.google.gson.annotations.SerializedName

data class JournalResponse(
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("date")
    val date: String,
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("userName")
    val userName: String,
)
