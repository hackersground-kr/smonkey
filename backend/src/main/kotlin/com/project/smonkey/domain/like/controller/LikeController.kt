package com.project.smonkey.domain.like.controller

import com.project.smonkey.domain.like.service.FeedDisLikeService
import com.project.smonkey.domain.like.service.FeedLikeService
import com.project.smonkey.global.payload.BaseResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.*

@Api(tags = ["글 좋아요 API"], description = "글 좋아요 API")
@RequestMapping("/like")
@RestController
class LikeController(
    private val feedLikeService: FeedLikeService,
    private val feedDisLikeService: FeedDisLikeService,
) {

    @ApiOperation(value = "글 좋아요")
    @PostMapping("/{feed-id}")
    fun like(
        @PathVariable("feed-id") feedId: Long,
    ): BaseResponse<Unit> {
        return feedLikeService.like(
            feedId = feedId,
        )
    }

    @ApiOperation(value = "글 좋아요 취소")
    @DeleteMapping("/{feed-id}")
    fun disLike(
        @PathVariable("feed-id") feedId: Long,
    ): BaseResponse<Unit> {
        return feedDisLikeService.disLike(
            feedId = feedId,
        )
    }
}
