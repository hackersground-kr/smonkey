package com.saehyun.data.network.smonkey

import com.google.gson.annotations.SerializedName

data class SmonkeyResponse(
    @field:SerializedName("backgroundColor")
    val backgroundColor: String,
    @field:SerializedName("level")
    val level: Int,
    @field:SerializedName("nextPoint")
    val nextPoint: Int,
    @field:SerializedName("point")
    val point: Int,
    @field:SerializedName("savePrice")
    val savePrice: Int,
    @field:SerializedName("spendPrice")
    val spendPrice: Int,
    @field:SerializedName("smokingDates")
    val smokingDates: SmokingDates,
    @field:SerializedName("smonkeyName")
    val smonkeyName: String,
    @field:SerializedName("step")
    val step: Int,
    @field:SerializedName("userName")
    val userName: String,
    @field:SerializedName("percentage")
    val percentage: Float,
)
