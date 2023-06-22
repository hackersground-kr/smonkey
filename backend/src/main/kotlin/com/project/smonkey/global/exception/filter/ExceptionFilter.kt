package com.project.smonkey.global.exception.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.smonkey.global.exception.GlobalException
import com.project.smonkey.global.exception.error.UnexpectException
import com.project.smonkey.global.payload.BaseResponse
import mu.KotlinLogging
import org.springframework.http.MediaType
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

private val kLogger = KotlinLogging.logger {}

class ExceptionFilter(
    private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (exception: Exception) {
            kLogger.error { exception.message }
            when (exception) {
                is GlobalException -> writeErrorCode(exception, response)
                else -> {
                    exception.printStackTrace()
                    writeErrorCode(UnexpectException.EXCEPTION, response)
                }
            }
        }
    }

    private fun writeErrorCode(exception: GlobalException, response: HttpServletResponse) {
        val errorResponse = BaseResponse.of(exception)

        response.characterEncoding = "UTF-8"
        response.status = errorResponse.status
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write(objectMapper.writeValueAsString(errorResponse))
    }
}
