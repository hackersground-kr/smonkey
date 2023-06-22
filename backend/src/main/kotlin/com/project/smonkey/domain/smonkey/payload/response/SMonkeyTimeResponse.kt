package com.project.smonkey.domain.smonkey.payload.response

data class SMonkeyTimeResponse(
    val noSmokingDay: Int,
    val noSmokingHour: Int,
    val noSmokingMinute: Int,
    val noSmokingSecond: Int,
    val smokingDay: Int,
    val smokingHour: Int,
    val smokingMinute: Int,
    val smokingSecond: Int,
)
