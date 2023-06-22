package com.project.smonkey.domain.like.exception.error

import com.project.smonkey.global.exception.error.ErrorResponse

enum class LikeErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorResponse {

    LIKE_ALREADY_EXIST(
        status = 409,
        message = "like already exist",
    ),

    LIKE_NOT_FOUND(
        status = 404,
        message = "like not found",
    ),
}
