package com.github.joelarmah.babyvaccination.data.remote.repository

import android.content.Context
import android.util.Log
import com.github.joelarmah.babyvaccination.R
import com.github.joelarmah.babyvaccination.data.local.database.dao.VaccinationScheduleDao
import com.github.joelarmah.babyvaccination.data.local.database.entity.VaccinationScheduleEntity
import com.github.joelarmah.babyvaccination.data.local.database.entity.Vaccine
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Singleton

@Singleton
class VaccinationScheduleRepositoryImpl(
    private val vaccinationScheduleDao: VaccinationScheduleDao
): VaccinationScheduleRepository  {

    private fun parseVaccinationJson(context: Context): List<VaccinationScheduleEntity> {
        val inputStream = context.resources.openRawResource(R.raw.vaccination)
        val json = inputStream.bufferedReader().use { it.readText() }

        return Gson().fromJson(json, object : TypeToken<List<VaccinationScheduleEntity>>() {}.type)
    }

//    fun generateScheduleFromJson(context: Context, babyDob: String): List<VaccinationScheduleEntity> {
//        val sdf = SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH)
//
//        val dob = sdf.parse(babyDob) ?: Date()
//
//        val parsedJson = parseVaccinationJson(context)
//
//        return parsedJson.map { item ->
//            val calendar = Calendar.getInstance().apply {
//                time = dob
//                add(Calendar.WEEK_OF_YEAR, item.ageInWeeks)
//            }
//            val actualDate = sdf.format(calendar.time)
//
//            VaccinationScheduleEntity(
//                ageInWeeks = item.ageInWeeks,
//                ageUserFriendly = item.ageUserFriendly,
//                actualDate = actualDate,
//                vaccines = item.vaccines.map { Vaccine(it.name, "") },
//                vitaminA = item.vitaminA,
//                deworming = item.deworming
//            )
//        }
//    }

    override suspend fun generateVaccinationSchedule(context: Context, dob: String): List<VaccinationScheduleEntity> {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH)
        val parsedDob = sdf.parse(dob) ?: Date()

        val parsedJson = parseVaccinationJson(context)

        Log.d("generateVaccinationSchedule", "parsedJson ==> $parsedJson")

        val schedule = parsedJson.map { item ->
//            val calendar = Calendar.getInstance().apply {
//                time = parsedDob
//                add(Calendar.WEEK_OF_YEAR, item.ageInWeeks)
//            }

            VaccinationScheduleEntity(
                ageInWeeks = item.ageInWeeks,
                ageUserFriendly = item.ageUserFriendly,
                actualDate = sdf.format(calculateActualDate(parsedDob, item.ageInWeeks)),
                vaccines = item.vaccines.map { Vaccine(it.name, "") },
                vitaminA = item.vitaminA,
                deworming = item.deworming
            )
        }

        vaccinationScheduleDao.insertAll(schedule)
        return schedule
    }

    private fun calculateActualDate(babyDob: Date, ageInWeeks: Int): Date {
        val calendar = Calendar.getInstance()
        calendar.time = babyDob

        // Add the weeks to the baby's DOB
        calendar.add(Calendar.WEEK_OF_YEAR, ageInWeeks)

        return calendar.time
    }

}