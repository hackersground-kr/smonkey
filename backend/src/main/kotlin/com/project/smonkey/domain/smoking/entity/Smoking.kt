package com.project.smonkey.domain.smoking.entity

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Smoking(
    @Id
    val userId: Long,
    val average: Int,
    val price: Int,
    val startAt: LocalDateTime,
    val endAt: LocalDateTime,
)
