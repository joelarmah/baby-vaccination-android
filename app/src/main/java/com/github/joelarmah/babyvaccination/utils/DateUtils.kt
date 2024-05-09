package com.github.joelarmah.babyvaccination.utils

import android.os.Build
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Date
import java.util.Locale

object DateUtils {

    fun formatDateFromMillis(millis: Long): String {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val date = LocalDate.ofEpochDay(millis / (24 * 60 * 60 * 1000))
            val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
            date.format(formatter)
        } else {
            val formatter = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            formatter.format(Date(millis))
        }

    }

}