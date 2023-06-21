package com.saehyun.presentation.util

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavType
import androidx.navigation.navArgument

internal fun buildExtra(key: String): String {
    return "$key{$key}"
}

internal fun putStringExtra(key: String, value: String): String {
    return key + value
}

internal fun smonkeyStringNavArgument(
    extra: String,
    defaultValue: String = ""
): NamedNavArgument {
    return navArgument(extra) {
        type = NavType.StringType
        this.defaultValue = defaultValue
    }
}

internal fun NavBackStackEntry.getStringExtra(
    extra: String,
    defaultValue: String = ""
): String {
    return arguments?.getString(extra) ?: defaultValue
}
