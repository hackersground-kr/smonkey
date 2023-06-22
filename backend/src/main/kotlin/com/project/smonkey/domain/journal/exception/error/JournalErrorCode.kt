package com.project.smonkey.domain.journal.exception.error

import com.project.smonkey.global.exception.error.ErrorResponse

enum class JournalErrorCode(
    override val status: Int,
    override val message: String,
): ErrorResponse {

    JOURNAL_NOT_FOUND(
        status = 404,
        message = "journal not found"
    ),

    JOURNAL_EXISTS(
        status = 409,
        message = "journal already exists"
    ),

    NOT_MY_JOURNAL(
        status = 403,
        message = "not my journal"
    )

}
