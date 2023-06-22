package com.project.smonkey.domain.smonkey.exception

import com.project.smonkey.domain.smonkey.exception.error.SMonkeyErrorCode
import com.project.smonkey.global.exception.GlobalException

object LevelNotFoundException : GlobalException(SMonkeyErrorCode.LEVEL_NOT_FOUND) {
    val EXCEPTION = LevelNotFoundException
}
