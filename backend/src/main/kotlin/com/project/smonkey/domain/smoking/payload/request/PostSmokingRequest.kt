package com.project.smonkey.domain.smoking.payload.request

import java.time.LocalDateTime

data class PostSmokingRequest(
    val average: Int,
    val price: Int,
    val startAt: LocalDateTime,
    val endAt: LocalDateTime,
)
