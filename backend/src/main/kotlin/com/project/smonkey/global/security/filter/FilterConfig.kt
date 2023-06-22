package com.project.smonkey.global.security.filter

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.smonkey.global.exception.filter.ExceptionFilter
import com.project.smonkey.global.security.jwt.JwtTokenProvider
import com.project.smonkey.global.security.logger.LogFilter
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper,
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {

        val tokenFilter = TokenFilter(jwtTokenProvider)
        val exceptionFilter = ExceptionFilter(objectMapper)
        val logFilter = LogFilter()

        builder.run {
            addFilterBefore(tokenFilter, UsernamePasswordAuthenticationFilter::class.java)
            addFilterBefore(exceptionFilter, TokenFilter::class.java)
            addFilterBefore(logFilter, ExceptionFilter::class.java)
        }
    }
}
