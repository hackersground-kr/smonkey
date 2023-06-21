package com.saehyun.common_android

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import java.io.ByteArrayOutputStream

fun Bitmap.encodeString(
    quality: Int = 100,
    format: Bitmap.CompressFormat = Bitmap.CompressFormat.PNG
): String {
    val byteArrayOutputStream = ByteArrayOutputStream()
    compress(format, quality, byteArrayOutputStream)
    val byteArray = byteArrayOutputStream.toByteArray()
    return Base64.encodeToString(byteArray, Base64.DEFAULT)
}

fun String.decodeBitmap(): Bitmap {
    return try {
        val decodedBytes = Base64.decode(this, Base64.DEFAULT)
        BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
    } catch (e: Exception) {
        throw IllegalStateException("bitmap null")
    }
}
