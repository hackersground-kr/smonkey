package com.project.smonkey.global.exception

import com.project.smonkey.global.exception.error.ErrorResponse

open class GlobalException(private val error: ErrorResponse) : RuntimeException() {
    val status: Int
        get() = error.status

    override val message: String
        get() = error.message
}
