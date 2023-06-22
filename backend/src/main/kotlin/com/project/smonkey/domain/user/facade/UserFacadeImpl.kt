package com.project.smonkey.domain.user.facade

import com.project.smonkey.domain.user.entity.User
import com.project.smonkey.domain.user.exception.UserNotFoundException
import com.project.smonkey.domain.user.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

/**
 * facade pattern in user
 *
 * @throws UserNotFoundException 유저를 찾을 수 없는 경우
 */
@Component
internal class UserFacadeImpl(
    private val userRepository: UserRepository,
) : UserFacade {

    override fun getById(id: Long): User =
        userRepository.findByIdOrNull(id) ?: throw UserNotFoundException.EXCEPTION

    override fun getByAccountId(accountId: String): User =
        userRepository.findByAccountId(accountId) ?: throw UserNotFoundException.EXCEPTION

    override fun getCurrentUser(): User {
        val currentUserAccountId = getAuthenticationName().name
        return getByAccountId(currentUserAccountId)
    }

    override fun getUserExist(accountId: String): Boolean {
        return userRepository.findByAccountId(accountId) != null
    }

    override fun searchUser(name: String): List<User> {
        return userRepository.findByNameContaining(
            name = name,
        )
    }

    private fun getAuthenticationName(): Authentication {
        return SecurityContextHolder.getContext().authentication ?: throw UserNotFoundException.EXCEPTION
    }
}
