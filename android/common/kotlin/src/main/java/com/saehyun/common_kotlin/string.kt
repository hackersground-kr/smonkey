package com.saehyun.common_kotlin

fun String.addBracket() =
    "($this)"

fun String.addBrace(): String {
    return "{$this}"
}
