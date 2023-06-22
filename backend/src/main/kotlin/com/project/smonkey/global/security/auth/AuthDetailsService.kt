package com.project.smonkey.global.security.auth

import com.project.smonkey.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userFacade: UserFacade,
) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {
        val user = userFacade.getByAccountId(username)

        return AuthDetails(
            user = user,
        )
    }
}
