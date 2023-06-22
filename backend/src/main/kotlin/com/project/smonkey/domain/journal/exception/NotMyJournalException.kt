package com.project.smonkey.domain.journal.exception

import com.project.smonkey.domain.journal.exception.error.JournalErrorCode
import com.project.smonkey.global.exception.GlobalException

object NotMyJournalException:  GlobalException(JournalErrorCode.NOT_MY_JOURNAL) {

    val EXCEPTION = NotMyJournalException

}
