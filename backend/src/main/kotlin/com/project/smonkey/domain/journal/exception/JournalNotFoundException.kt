package com.project.smonkey.domain.journal.exception

import com.project.smonkey.domain.journal.exception.error.JournalErrorCode
import com.project.smonkey.global.exception.GlobalException

object JournalNotFoundException: GlobalException(JournalErrorCode.JOURNAL_NOT_FOUND) {

    val EXCEPTION = JournalNotFoundException

}
