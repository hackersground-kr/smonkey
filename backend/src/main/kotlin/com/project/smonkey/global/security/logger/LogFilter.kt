package com.project.smonkey.global.security.logger

import mu.KotlinLogging
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

private val kLogger = KotlinLogging.logger {}

class LogFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {
        kLogger.info {
            StringBuilder()
                .append("Client")
                .append(" ")
                .append(getRemoteAddress(request))
                .append("Request to")
                .append(" ")
                .append(request.method)
                .append(" ")
                .append(request.requestURL)
                .append(" ")
                .append("with header names: ")
                .append(getHeaders(request))
                .toString()
        }
        filterChain.doFilter(request, response)
    }

    private fun getRemoteAddress(request: HttpServletRequest): String {
        return when (request.getHeader("X-FORWARDED-FOR")) {
            null -> request.remoteAddr
            else -> request.getHeader("X-FORWARDED-FOR")
        }
    }

    private fun getHeaders(request: HttpServletRequest): String {
        return request.headerNames.toList().toString()
    }
}
