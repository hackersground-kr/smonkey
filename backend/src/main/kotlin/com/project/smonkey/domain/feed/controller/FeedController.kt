package com.project.smonkey.domain.feed.controller

import com.project.smonkey.domain.feed.payload.request.SaveFeedRequest
import com.project.smonkey.domain.feed.payload.request.UpdateFeedRequest
import com.project.smonkey.domain.feed.payload.response.GetFeedListResponse
import com.project.smonkey.domain.feed.payload.response.GetFeedResponse
import com.project.smonkey.domain.feed.service.DeleteFeedService
import com.project.smonkey.domain.feed.service.GetFeedService
import com.project.smonkey.domain.feed.service.SaveFeedService
import com.project.smonkey.domain.feed.service.UpdateFeedService
import com.project.smonkey.global.payload.BaseResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Api(tags = ["글 API"], description = "글 API")
@RequestMapping("/feed")
@RestController
class FeedController(
    private val saveFeedService: SaveFeedService,
    private val updateFeedService: UpdateFeedService,
    private val deleteFeedService: DeleteFeedService,
    private val getFeedService: GetFeedService,
) {

    @ApiOperation(value = "글 쓰기")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveFeed(
        @RequestParam("category") category: String,
        @RequestBody request: SaveFeedRequest,
    ): BaseResponse<Unit> {
        return saveFeedService.saveFeed(
            category = category,
            request = request,
        )
    }

    @ApiOperation(value = "글 수정")
    @PatchMapping("/{feed-id}/update")
    fun updateFeed(
        @PathVariable("feed-id") feedId: Long,
        @RequestParam("category") category: String,
        @RequestBody request: UpdateFeedRequest,
    ): BaseResponse<Unit> {
        return updateFeedService.updateFeed(
            feedId = feedId,
            category = category,
            request = request,
        )
    }

    @ApiOperation(value = "글 삭제")
    @DeleteMapping("/{feed-id}")
    fun deleteFeed(
        @PathVariable("feed-id") feedId: Long,
    ): BaseResponse<Unit> {
        return deleteFeedService.deleteFeed(
            feedId = feedId,
        )
    }

    @ApiOperation(value = "글 상세 조회")
    @GetMapping("/{feed-id}")
    fun getFeed(
        @PathVariable("feed-id") feedId: Long,
    ): BaseResponse<GetFeedResponse> {
        return getFeedService.getFeed(
            feedId = feedId,
        )
    }

    @ApiOperation(value = "글 목록")
    @GetMapping("/list")
    fun getFeedList(
        @RequestParam("category") category: String,
    ): BaseResponse<GetFeedListResponse> {
        return getFeedService.getFeedList(
            category = category,
        )
    }
}
