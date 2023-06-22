package com.project.smonkey.domain.user.controller

import com.project.smonkey.domain.user.payload.request.SignInRequest
import com.project.smonkey.domain.user.payload.request.SignUpRequest
import com.project.smonkey.domain.user.service.SignInService
import com.project.smonkey.domain.user.service.SignUpService
import com.project.smonkey.global.payload.BaseResponse
import com.project.smonkey.global.security.jwt.payload.TokenResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@Api(tags = ["유저 API"], description = "유저 API")
@RequestMapping("/user")
@RestController
class UserController(
    private val signUpService: SignUpService,
    private val signInService: SignInService,
) {

    @ApiOperation(value = "회원가입")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun signUp(
        @RequestBody request: SignUpRequest,
    ): BaseResponse<TokenResponse> {
        return signUpService.signUp(
            request = request,
        )
    }

    @ApiOperation(value = "로그인")
    @PostMapping("/signin")
    fun signIn(
        @RequestBody request: SignInRequest,
    ): BaseResponse<TokenResponse> {
        return signInService.signIn(
            request = request,
        )
    }
}
