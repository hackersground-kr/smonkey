package com.saehyun.presentation.component

import com.saehyun.presentation.R

fun Int.toSmonkeyCharacter(): Int =
    when (this) {
        1 -> R.drawable.character_smonkey_1
        2 -> R.drawable.character_smonkey_2
        3 -> R.drawable.character_smonkey_3
        else -> R.drawable.character_smonkey_4
    }