package com.saehyun.common_kotlin

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object SlingDateParsingPattern {
    const val Default = "yyyy-MM-dd"
    const val ISO8601Format = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
}

fun Date.formatString(
    pattern: String = SlingDateParsingPattern.Default,
    locale: Locale = Locale.KOREA
): String {
    return try {
        val formatter = SimpleDateFormat(pattern, locale)
        formatter.format(this)
    } catch (e: ParseException) {
        throw ParseException(e.message, e.errorOffset)
    }
}

fun String.parseDate(
    pattern: String = SlingDateParsingPattern.Default,
    locale: Locale = Locale.KOREA
): Date {
    return try {
        val formatter = SimpleDateFormat(pattern, locale)
        formatter.parse(this) ?: throw ParseException("Date is null", 0)
    } catch (e: ParseException) {
        throw ParseException(e.message, e.errorOffset)
    }
}
