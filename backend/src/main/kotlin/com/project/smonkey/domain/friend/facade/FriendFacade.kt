package com.project.smonkey.domain.friend.facade

import com.project.smonkey.domain.friend.entity.Friend
import com.project.smonkey.domain.user.entity.User

interface FriendFacade {

    fun createFriend(friend: Friend)

    fun refuseFriend(friend: Friend)

    fun getBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Friend

    fun existsBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Boolean

    fun getFriendList(
        userId: Long,
    ): List<User>

    fun getRequestFriendList(
        userId: Long,
    ): List<User>
}
