package com.github.joelarmah.babyvaccination.data.model

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

data class VaccineSchedule(
    val ageInWeeks: Int,
    val vaccine: List<Vaccine> = listOf(),
    val date: String
)

fun generateVaccineSchedule(dateOfBirth: Date): List<VaccineSchedule> {
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    val calendar = Calendar.getInstance()
    calendar.time = dateOfBirth

    val vaccineSchedule = mutableListOf<VaccineSchedule>()

    // Add each vaccine with its corresponding age in weeks
    vaccineSchedule.addAll(
        listOf(
            VaccineSchedule(
                0,
                listOf(
                    Vaccine("BCG"),
                    Vaccine("OPV 0"),
                    Vaccine("Hepatitis B")
                ),
                sdf.format(calendar.time)
            ),
            VaccineSchedule(
                6,
                listOf(
                    Vaccine("OPV 1"),
                    Vaccine("DPT/ Hep B/ Hib 1"),
                    Vaccine("Pneumococcal 1"),
                    Vaccine("Rotavirus 1")
                ),
                sdf.format(getDateAfterWeeks(calendar.time, 6))
            ),
            VaccineSchedule(
                10,
                listOf(
                    Vaccine("OPV 2"),
                    Vaccine("DPT/ Hep B/ Hib 2"),
                    Vaccine("Pneumococcal 2"),
                    Vaccine("Rotavirus 2")
                ),
                sdf.format(getDateAfterWeeks(calendar.time, 10))
            ),
        )
    )
    return vaccineSchedule
}

fun getDateAfterWeeks(startDate: Date, weeks: Int): Date {
    val calendar = Calendar.getInstance()
    calendar.time = startDate
    calendar.add(Calendar.WEEK_OF_YEAR, weeks)
    return calendar.time
}

fun main() {
    // Example usage
    val dateOfBirth = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).parse("01/01/2024")
    val vaccineSchedule = dateOfBirth?.let { generateVaccineSchedule(it) }
    vaccineSchedule?.forEach {
        println("Age: ${it.ageInWeeks} weeks, Vaccine: ${it.vaccine}, Date: ${it.date}")
    }
}