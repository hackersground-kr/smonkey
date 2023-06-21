package com.saehyun.presentation.util

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import java.lang.ref.WeakReference

class ToastWrapper(context: Context) {
    private val _context = WeakReference(context)
    private val context get() = _context.get()!!
    private val toast = Toast.makeText(context, "", Toast.LENGTH_SHORT)

    operator fun invoke(message: Any, length: Int = Toast.LENGTH_SHORT) {
        toast.run {
            setText(message.toString())
            duration = length
            show()
        }
    }

    operator fun invoke(
        @StringRes stringRes: Int,
        vararg args: Any,
        length: Int = Toast.LENGTH_SHORT
    ) {
        toast.run {
            setText(context.getString(stringRes, *args))
            duration = length
            show()
        }
    }
}

@Composable
fun rememberToast(): ToastWrapper {
    val context = LocalContext.current.applicationContext
    return remember(context) {
        ToastWrapper(context)
    }
}
