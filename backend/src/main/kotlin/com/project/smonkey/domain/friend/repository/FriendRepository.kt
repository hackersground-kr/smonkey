package com.project.smonkey.domain.friend.repository

import com.project.smonkey.domain.friend.utils.FriendStatus
import com.project.smonkey.domain.friend.entity.Friend
import org.springframework.data.repository.CrudRepository

interface FriendRepository : CrudRepository<Friend, Long> {

    fun getAllBySenderIdAndStatusIn(
        senderId: Long,
        statuses: List<FriendStatus>,
    ): List<Friend>

    fun getAllByReceiverIdAndStatusIn(
        receiverId: Long,
        statuses: List<FriendStatus>,
    ): List<Friend>

    fun existsBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Boolean

    fun getBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Friend?
}
