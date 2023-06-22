package com.project.smonkey.domain.user.entity

import java.time.LocalDateTime
import java.util.Date
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class User(
    val accountId: String,
    val password: String,
    val name: String,
    val email: String,
    val age: Int,
    val amount: Int,
    val price: Int,
    val smokingDate: Date,
    val noSmokingDate: Date,
    val reason: String,
    val cigaretteAmount: Int,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0
}
