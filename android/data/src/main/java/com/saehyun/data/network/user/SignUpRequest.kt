package com.saehyun.data.network.user

import com.google.gson.annotations.SerializedName
import com.saehyun.common_android.ColorType
import java.time.LocalDateTime
import java.util.Date

data class SignUpRequest(
    @field:SerializedName("accountId")
    val accountId: String,
    @field:SerializedName("age")
    val age: Int,
    @field:SerializedName("amount")
    val amount: Int,
    @field:SerializedName("cigaretteAmount")
    val cigaretteAmount: Int,
    @field:SerializedName("email")
    val email: String,
    @field:SerializedName("name")
    val name: String,
    @field:SerializedName("noSmokingDate")
    val noSmokingDate: String,
    @field:SerializedName("password")
    val password: String,
    @field:SerializedName("price")
    val price: Int,
    @field:SerializedName("reason")
    val reason: String,
    @field:SerializedName("smokingDate")
    val smokingDate: String,
    @field:SerializedName("sMonkeyName")
    val sMonkeyName: String,
    @field:SerializedName("backgroundColor")
    val backgroundColor: ColorType,
)
