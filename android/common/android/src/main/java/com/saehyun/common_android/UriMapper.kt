package com.saehyun.common_android

import android.net.Uri
import java.net.URI

fun URI.toUri(): Uri = Uri.parse(this.toString())

fun Uri.toURI(): URI = URI(this.toString())
