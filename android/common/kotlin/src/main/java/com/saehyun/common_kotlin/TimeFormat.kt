package com.saehyun.common_kotlin

fun Int.formatTime(): String {
    val minutes = this / 60
    val remainingSeconds = this % 60
    return "${minutes}분 ${remainingSeconds}초"
}
