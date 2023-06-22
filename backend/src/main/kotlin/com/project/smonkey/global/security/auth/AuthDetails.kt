package com.project.smonkey.global.security.auth

import com.project.smonkey.domain.user.entity.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

/**
 * Auth의 상세 정보를 다루는 class
 *
 * @param user User의 기본적인 정보
 */
class AuthDetails(
    private val user: User,
) : UserDetails {
    override fun getAuthorities():
        MutableCollection<out GrantedAuthority> = mutableListOf()

    override fun getPassword(): String = user.password

    override fun getUsername(): String = user.accountId

    override fun isAccountNonExpired(): Boolean = DefaultAccountNonExpired

    override fun isAccountNonLocked(): Boolean = DefaultAccountNonLocked

    override fun isCredentialsNonExpired(): Boolean = DefaultCredentialsNonExpired

    override fun isEnabled(): Boolean = DefaultEnabled

    /**
     * [AuthDetails] 의 Default Value를 정의한 Object
     */
    companion object {
        private const val DefaultAccountNonExpired: Boolean = true
        private const val DefaultAccountNonLocked: Boolean = true
        private const val DefaultCredentialsNonExpired: Boolean = true
        private const val DefaultEnabled: Boolean = true
    }
}
