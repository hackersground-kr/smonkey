package com.saehyun.common_kotlin

/**
 * [condition]이 참이면 [run]을 return
 */
inline fun <T> T.runIf(
    condition: Boolean,
    run: T.() -> T
) = if (condition) {
    run()
} else {
    this
}
