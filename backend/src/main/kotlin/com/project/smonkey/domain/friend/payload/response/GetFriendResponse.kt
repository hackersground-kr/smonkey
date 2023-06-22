package com.project.smonkey.domain.friend.payload.response

data class GetFriendResponse(
    val friendList: List<Friend>,
) {
    data class Friend(
        val friendId: Long,
        val userName: String,
        val smonkeyName: String,
        val backgroundColor: String,
        val step: Int,
        val point: Int,
        val level: Int,
        val nextPoint: Int,
    )
}
