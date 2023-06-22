package com.project.smonkey.domain.friend.payload.response

data class SearchFriendResponse(
    val userList: List<User>,
) {
    data class User(
        val friendId: Long,
        val friendAccountId: String,
        val userName: String,
        val smonkeyName: String,
        val backgroundColor: String,
        val step: Int,
        val point: Int,
        val level: Int,
        val nextPoint: Int,
    )
}
