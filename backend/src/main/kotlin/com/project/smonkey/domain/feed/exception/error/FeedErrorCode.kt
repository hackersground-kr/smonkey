package com.project.smonkey.domain.feed.exception.error

import com.project.smonkey.global.exception.error.ErrorResponse

enum class FeedErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorResponse {

    POST_NOT_FOUND(
        status = 404,
        message = "post not found",
    ),

    FEED_TYPE_NOT_EXIST(
        status = 401,
        message = "feed type not exist",
    ),

    NOT_MY_FEED(
        status = 403,
        message = "this post is not your post"
    ),
}
