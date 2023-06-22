package com.project.smonkey.domain.friend.controller

import com.project.smonkey.domain.friend.payload.response.GetFriendResponse
import com.project.smonkey.domain.friend.payload.response.GetRequestFriendListResponse
import com.project.smonkey.domain.friend.payload.response.SearchFriendResponse
import com.project.smonkey.domain.friend.service.*
import com.project.smonkey.global.payload.BaseResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Api(tags = ["친구 API"], description = "친구 API")
@RequestMapping("/friend")
@RestController
class FriendController(
    private val requestFriendService: RequestFriendService,
    private val acceptFriendService: AcceptFriendService,
    private val getFriendService: GetFriendService,
    private val refuseFriendService: RefuseFriendService,
    private val getRequestFriendListService: GetRequestFriendListService,
    private val searchFriendService: SearchFriendService,
) {

    @ApiOperation(value = "친구 추가")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun requestFriend(
        @RequestParam("account-id") accountId: String,
    ): BaseResponse<Unit> {
        return requestFriendService.requestFriend(
            accountId = accountId,
        )
    }

    @ApiOperation(value = "친구 검색")
    @GetMapping("/search")
    fun searchFriend(
        @RequestParam("name") name: String,
    ): BaseResponse<SearchFriendResponse> {
        return searchFriendService.searchFriend(
            name = name,
        )
    }

    @ApiOperation(value = "친구 수락")
    @PostMapping("/accept")
    fun acceptFriend(
        @RequestParam("friend-id") friendId: Long,
    ): BaseResponse<Unit> {
        return acceptFriendService.acceptFriend(
            friendId = friendId,
        )
    }

    @ApiOperation(value = "친구 거절")
    @PostMapping("/refuse")
    fun refuseFriend(
        @RequestParam("friend-id") friendId: Long,
    ): BaseResponse<Unit> {
        return refuseFriendService.refuseFriend(
            friendId = friendId,
        )
    }

    @ApiOperation(value = "친구 목록")
    @GetMapping
    fun getFriend(): BaseResponse<GetFriendResponse> {
        return getFriendService.getFriend()
    }

    @ApiOperation(value = "친구 요청 목록")
    @GetMapping("/request")
    fun getRequestFriendList(): BaseResponse<GetRequestFriendListResponse> {
        return getRequestFriendListService.getFriendRequestList()
    }
}
