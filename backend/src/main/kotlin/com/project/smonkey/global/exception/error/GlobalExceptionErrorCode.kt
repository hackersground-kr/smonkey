package com.project.smonkey.global.exception.error

enum class GlobalExceptionErrorCode(
    override val status: Int,
    override val message: String
) : ErrorResponse {

    INVALID_METHOD_ARGUMENT(
        status = 400,
        message = "Invalid Method Argument",
    ),

    UNEXPECT(
        status = 500,
        message = "unexpect exception occurred",
    ),
}
