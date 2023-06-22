package com.project.smonkey.global.extension

fun <T> T.runIf(condition: Boolean, block: T.() -> T): T = if (condition) block() else this
