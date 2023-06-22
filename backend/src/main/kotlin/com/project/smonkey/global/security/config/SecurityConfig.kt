package com.project.smonkey.global.security.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.project.smonkey.global.security.filter.FilterConfig
import com.project.smonkey.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val jwtTokenProvider: JwtTokenProvider,
    private val objectMapper: ObjectMapper,
) {

    @Bean
    fun webSecurityCustomizer(): WebSecurityCustomizer? {
        return WebSecurityCustomizer { web: WebSecurity ->
            web.ignoring()
                .mvcMatchers(
                    "/swagger-ui/**", "/configuration/**", "/swagger-resources/**",
                    "/v3/api-docs/**", "/webjars/**", "/webjars/springfox-swagger-ui/*.{js,css}", "/bus/v3/api-docs/**"
                )
        }
    }

    @Bean
    protected fun filterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors().and()
            .csrf().disable()
            .formLogin().disable()
            .authorizeRequests()
            .antMatchers("/user").permitAll()
            .antMatchers("/user/signin").permitAll()
            .anyRequest().authenticated()
            .and()
            .apply(
                FilterConfig(
                    jwtTokenProvider = jwtTokenProvider,
                    objectMapper = objectMapper,
                )
            )

        return http.build()
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder()
}
