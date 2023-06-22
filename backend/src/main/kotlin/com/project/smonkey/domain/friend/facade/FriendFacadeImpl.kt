package com.project.smonkey.domain.friend.facade

import com.project.smonkey.domain.friend.entity.Friend
import com.project.smonkey.domain.friend.exception.FriendNotFoundException
import com.project.smonkey.domain.friend.repository.FriendRepository
import com.project.smonkey.domain.friend.utils.FriendStatus
import com.project.smonkey.domain.user.entity.User
import org.springframework.stereotype.Component

@Component
class FriendFacadeImpl(
    private val friendRepository: FriendRepository,
) : FriendFacade {

    override fun createFriend(
        friend: Friend,
    ) {
        friendRepository.save(friend)
    }

    override fun refuseFriend(
        friend: Friend,
    ) {
        friendRepository.delete(friend)
    }

    override fun getBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Friend {
        return friendRepository.getBySenderIdAndReceiverId(
            senderId = senderId,
            receiverId = receiverId,
        ) ?: throw FriendNotFoundException
    }

    override fun existsBySenderIdAndReceiverId(
        senderId: Long,
        receiverId: Long,
    ): Boolean {
        return friendRepository.existsBySenderIdAndReceiverId(
            senderId = senderId,
            receiverId = receiverId,
        )
    }

    override fun getFriendList(userId: Long): List<User> {

        val statuses = listOf(
            FriendStatus.ACCEPTED,
            FriendStatus.ACCEPTED_REVERSE,
        )

        val senderId: List<User> = friendRepository.getAllBySenderIdAndStatusIn(
            senderId = userId,
            statuses = statuses,
        ).map { it.receiver }

        val receiverId: List<User> = friendRepository.getAllByReceiverIdAndStatusIn(
            receiverId = userId,
            statuses = statuses,
        ).map { it.sender }

        val friendList = senderId.union(receiverId)

        return friendList.toList()
    }

    override fun getRequestFriendList(userId: Long): List<User> {

        val statuses = listOf(
            FriendStatus.PENDING,
        )

        val receiver: List<User> = friendRepository.getAllByReceiverIdAndStatusIn(
            receiverId = userId,
            statuses = statuses,
        ).map { it.sender }

        return receiver.toList()
    }
}
