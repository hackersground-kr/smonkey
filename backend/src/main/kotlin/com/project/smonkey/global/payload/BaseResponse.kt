package com.project.smonkey.global.payload

import com.project.smonkey.global.exception.GlobalException
import com.fasterxml.jackson.annotation.JsonInclude

/**
 * 모든 Response의 Base가 되는 클래스 [BaseResponse]
 *
 * @param status 앱의 상태
 * @param message 처리 결과 메시지
 * @param content 요청한 response 값
 */
class BaseResponse<T>(
    val status: Int,
    val message: String,
    @JsonInclude(JsonInclude.Include.NON_NULL)
    val content: T?
) {
    companion object {
        fun of(e: GlobalException): BaseResponse<Unit> {
            return BaseResponse(
                status = e.status,
                message = e.message,
                content = null
            )
        }
    }
}
