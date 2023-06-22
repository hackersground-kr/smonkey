package com.project.smonkey.domain.user.payload.request

import java.util.Date

data class SignUpRequest(
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
    val sMonkeyName: String,
    val backgroundColor: String,
)
