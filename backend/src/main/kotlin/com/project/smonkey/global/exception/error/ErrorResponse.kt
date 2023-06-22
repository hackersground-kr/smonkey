package com.project.smonkey.global.exception.error

/**
 * ErrorResponse 기본적인 인터페이스
 */
interface ErrorResponse {
    val status: Int
    val message: String
}
