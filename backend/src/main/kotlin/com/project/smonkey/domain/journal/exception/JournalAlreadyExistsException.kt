package com.project.smonkey.domain.journal.exception

import com.project.smonkey.domain.journal.exception.error.JournalErrorCode
import com.project.smonkey.global.exception.GlobalException

object JournalAlreadyExistsException: GlobalException(JournalErrorCode.JOURNAL_EXISTS) {

    val EXCEPTION = JournalAlreadyExistsException

}
