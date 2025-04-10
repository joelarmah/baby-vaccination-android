package com.github.joelarmah.babyvaccination.data.local.database.converters

import androidx.room.TypeConverter
import com.github.joelarmah.babyvaccination.data.local.database.entity.Vaccine
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class Converters {

    val gson = Gson()

    // Convert a List<Vaccine> to a JSON string
    @TypeConverter
    fun fromVaccineList(vaccines: List<Vaccine>?): String? {
        return gson.toJson(vaccines)
    }

    // Convert a JSON string to a List<Vaccine>
    @TypeConverter
    fun toVaccineList(vaccinesString: String?): List<Vaccine>? {
        val type = object : TypeToken<List<Vaccine>>() {}.type
        return gson.fromJson(vaccinesString, type)
    }

}