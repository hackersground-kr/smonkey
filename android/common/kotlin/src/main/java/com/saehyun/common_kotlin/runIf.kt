package com.saehyun.common_kotlin

inline fun <T> T.runIf(
    condition: Boolean,
    run: T.() -> T,
) = if (condition) {
    run()
} else {
    this
}
