package com.avazpar.eventdog.home.presentation

import java.text.SimpleDateFormat
import java.util.*

private const val GMT_TIMEZONE = "GMT"
const val DATE_NOT_ISO_FORMAT_WITH_SLASH = "dd/MM/yyyy"
const val HOUR_NOT_ISO_FORMAT = "HH:mm"
const val TIMESTAMP_ISO_STRING_PATTERN = "yyyy-MM-dd'T'HH:mm:ss"

fun Date.toFormatDateString(): String = toFormat(DATE_NOT_ISO_FORMAT_WITH_SLASH)
fun Date.toFormatHourString(): String = toFormat(HOUR_NOT_ISO_FORMAT)

fun Date.toFormat(format: String, locale: Locale = Locale.ENGLISH, timeZone: TimeZone = TimeZone.getDefault()): String {
    val dateFormat = SimpleDateFormat(format, locale)
    dateFormat.timeZone = timeZone
    return dateFormat.format(this)
}

fun String.toDate(format: String, locale: Locale = Locale.getDefault()): Date? =
    try {
        val formatter = SimpleDateFormat(format, locale)
        formatter.timeZone = TimeZone.getTimeZone(GMT_TIMEZONE)
        formatter.parse(this)
    } catch (throwable: Throwable) {
        null
    }
