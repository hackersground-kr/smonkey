package com.project.smonkey.domain.friend.utils

enum class FriendStatus {
    PENDING,
    ACCEPTED,
    ACCEPTED_REVERSE,
}

internal fun FriendStatus.isPending() =
    this == FriendStatus.PENDING
