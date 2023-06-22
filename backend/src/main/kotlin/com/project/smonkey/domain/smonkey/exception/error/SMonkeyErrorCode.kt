package com.project.smonkey.domain.smonkey.exception.error

import com.project.smonkey.global.exception.error.ErrorResponse

enum class SMonkeyErrorCode(
    override val status: Int,
    override val message: String,
) : ErrorResponse {

    /**
     * 존재하지 않는 색깔일 경
     */
    COLOR_NOT_FOUND(
        status = 401,
        message = "color not found",
    ),

    /**
     * 스몽키가 이미 존재 할 경우
     */
    SMONKEY_ALREADY_EXIST(
        status = 409,
        message = "smonkey already exist",
    ),

    /**
     * 스몽키가 존재하지 않는 경우
     */
    SMONKEY_NOT_FOUND(
        status = 404,
        message = "smonkey not found",
    ),

    /**
     * 레벨이 확인되지 않는 경우
     */
    LEVEL_NOT_FOUND(
        status = 404,
        message = "level not found",
    ),

    /**
     * 금연 단계와 확인되지 않는 경우
     */
    SMOKING_STEP_NOT_FOUND(
        status = 404,
        message = "smoking step not found"
    )
}
