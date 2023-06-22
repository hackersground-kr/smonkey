package com.project.smonkey.domain.friend.service

import com.project.smonkey.domain.friend.facade.FriendFacade
import com.project.smonkey.domain.friend.payload.response.GetFriendResponse
import com.project.smonkey.domain.smonkey.facade.SMonkeyFacade
import com.project.smonkey.domain.smonkey.mapper.toLevel
import com.project.smonkey.domain.smonkey.mapper.levelToNextMaxPoint
import com.project.smonkey.domain.smonkey.mapper.pointToCurrentPoint
import com.project.smonkey.domain.smonkey.mapper.toStep
import com.project.smonkey.domain.user.facade.UserFacade
import com.project.smonkey.global.payload.BaseResponse
import org.springframework.stereotype.Service

@Service
class GetFriendService(
    private val userFacade: UserFacade,
    private val smonkeyFacade: SMonkeyFacade,
    private val friendFacade: FriendFacade,
) {

    fun getFriend(): BaseResponse<GetFriendResponse> {

        val user = userFacade.getCurrentUser()
        val friendList = friendFacade.getFriendList(user.id)

        val getFriendResponse = GetFriendResponse(
            friendList = friendList.map { friend ->

                val friendUser = userFacade.getById(friend.id)
                val smonkey = smonkeyFacade.getSMonkeyById(friend.id)

                val level = smonkey.point.toLevel()

                GetFriendResponse.Friend(
                    friendId = friend.id,
                    userName = friendUser.name,
                    smonkeyName = smonkey.name,
                    backgroundColor = smonkey.backgroundColor,
                    step = level.toStep(),
                    point = smonkey.point.pointToCurrentPoint(),
                    level = level,
                    nextPoint = level.levelToNextMaxPoint(),
                )
            }
        )

        return BaseResponse(
            status = 200,
            message = GET_FRIEND_SUCCESS_MESSAGE,
            content = getFriendResponse,
        )
    }

    companion object {
        const val GET_FRIEND_SUCCESS_MESSAGE = "success to get friend"
    }
}
