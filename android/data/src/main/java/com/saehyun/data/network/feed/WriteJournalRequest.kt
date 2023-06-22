package com.saehyun.data.network.feed

import com.google.gson.annotations.SerializedName

data class WriteJournalRequest(
    @field:SerializedName("title")
    val title: String,
    @field:SerializedName("content")
    val content: String,
    @field:SerializedName("date")
    val date: String,
)
