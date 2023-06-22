package com.project.smonkey.global.exception.handler

import com.project.smonkey.global.exception.GlobalException
import com.project.smonkey.global.exception.error.InvalidMethodArgumentException
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun methodArgumentValid(): ResponseEntity<BaseResponse<Unit>> {
        return handleException(InvalidMethodArgumentException.EXCEPTION)
    }

    @ExceptionHandler(GlobalException::class)
    fun globalException(
        e: GlobalException
    ): ResponseEntity<BaseResponse<Unit>> {
        return handleException(e)
    }

    private fun handleException(e: GlobalException): ResponseEntity<BaseResponse<Unit>> {
        val httpStatus = HttpStatus.valueOf(e.status)
        val body = BaseResponse.of(e)
        return ResponseEntity(body, httpStatus)
    }
}
