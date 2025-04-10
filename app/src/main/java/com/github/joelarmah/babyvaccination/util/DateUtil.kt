package com.github.joelarmah.babyvaccination.util

import android.os.Build
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

fun formatDateFromMillis(millis: Long, pattern: String = "yyyy-MM-dd"): String {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val localDate: LocalDate = Instant.ofEpochMilli(millis)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()
         localDate.format(DateTimeFormatter.ofPattern(pattern))
    } else {
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())
        sdf.format(Date(millis))
    }
}

fun reformatDate(input: String, inputFormat: String = "yyyy-MM-dd", outputFormat: String = "MMMM d, yyyy"): String {
    val inputSdf = SimpleDateFormat(inputFormat, Locale.ENGLISH)
    val outputSdf = SimpleDateFormat(outputFormat, Locale.ENGLISH)

    return try {
        val date = inputSdf.parse(input)
        if (date != null) {
            outputSdf.format(date)
        } else {
            ""
        }
    } catch (e: Exception) {
        e.printStackTrace()
        ""
    }
}