package com.saehyun.data.network.feed

data class Writer(
    val backgroundColor: String,
    val level: Int,
    val nextPoint: Int,
    val point: Int,
    val smonkeyName: String,
    val step: Int,
    val userName: String,
) {
    companion object {
        fun dummy() = Writer(
            backgroundColor = "FFFFFF",
            level = 0,
            nextPoint = 0,
            point = 0,
            smonkeyName = "뽀로로",
            step = 1,
            userName = "물개새끼",
        )
    }
}
