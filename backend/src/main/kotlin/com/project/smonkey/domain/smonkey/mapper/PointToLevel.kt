package com.project.smonkey.domain.smonkey.mapper

import com.project.smonkey.domain.smonkey.exception.LevelNotFoundException
import com.project.smonkey.domain.smonkey.utils.SMonkeyLevel

internal fun Int.toLevel(): Int {
    SMonkeyLevel.reversed().forEach { level ->
        if (this >= level.targetPoint) {
            return level.level
        }
    }

    throw LevelNotFoundException.EXCEPTION
}

/**
 * 레벨을 통해 현재 Max Point를 가져옵니다.
 */
internal fun Int.levelToCurrentMaxPoint(): Int {
    return SMonkeyLevel[this - 1].targetPoint
}

internal fun Int.pointToCurrentPoint(): Int {
    val level = this.toLevel()
    val currentMax = level.levelToCurrentMaxPoint()

    return this - currentMax
}

internal fun Int.levelToNextMaxPoint(): Int {
    val nextMaxPoint = SMonkeyLevel[this].targetPoint
    val currentMaxPoint = this.levelToCurrentMaxPoint()

    return nextMaxPoint - currentMaxPoint
}
