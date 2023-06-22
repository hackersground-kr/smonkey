package com.saehyun.data.network.smonkey

import com.google.gson.annotations.SerializedName

data class SmokingDates(
    @field:SerializedName("noSmokingDay")
    val noSmokingDay: Int,
    @field:SerializedName("noSmokingHour")
    val noSmokingHour: Int,
    @field:SerializedName("noSmokingMinute")
    val noSmokingMinute: Int,
    @field:SerializedName("noSmokingSecond")
    val noSmokingSecond: Int,
    @field:SerializedName("smokingDay")
    val smokingDay: Int,
    @field:SerializedName("smokingHour")
    val smokingHour: Int,
    @field:SerializedName("smokingMinute")
    val smokingMinute: Int,
    @field:SerializedName("smokingSecond")
    val smokingSecond: Int,
)
