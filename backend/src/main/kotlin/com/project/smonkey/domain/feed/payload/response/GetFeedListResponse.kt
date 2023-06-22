package com.project.smonkey.domain.feed.payload.response

import com.project.smonkey.domain.feed.enum.FeedType

data class GetFeedListResponse(
    val feedList: List<Feed>,
) {
    data class Feed(
        val writer: Writer,
        val feedId: Long,
        val title: String,
        val likeCount: Int,
        val isLike: Boolean,
        val content: String,
        val category: FeedType,
        val createdAt: String,
    ) {
        data class Writer(
            val userName: String,
            val smonkeyName: String,
            val backgroundColor: String,
            val step: Int,
            val point: Int,
            val level: Int,
            val nextPoint: Int,
        )
    }
}
