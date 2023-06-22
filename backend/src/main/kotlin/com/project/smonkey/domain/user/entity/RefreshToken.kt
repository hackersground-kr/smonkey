package com.project.smonkey.domain.user.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.TimeToLive
import org.springframework.data.redis.core.index.Indexed

/**
 * RefreshToken Entity
 *
 * @param accountId 계정 아이디
 * @param token refresh token
 * @param ttl 토큰 만료
 */
@RedisHash
data class RefreshToken(

    @Id
    val accountId: String,

    @Indexed
    val token: String,

    @TimeToLive
    val ttl: Long
)
