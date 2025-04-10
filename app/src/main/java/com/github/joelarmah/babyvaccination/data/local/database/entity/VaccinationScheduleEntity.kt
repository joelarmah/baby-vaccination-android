package com.github.joelarmah.babyvaccination.data.local.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "vaccination_schedules")
data class VaccinationScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @SerializedName("age_in_weeks")
    val ageInWeeks: Int = -1,
    @SerializedName("age_user_friendly")
    val ageUserFriendly: String = "",
    @SerializedName("actual_date")
    val actualDate: String = "", // Date based on baby Dob (April 21, 2024)
    @SerializedName("vaccines")
    val vaccines: List<Vaccine> = emptyList(),
    @SerializedName("vitamin_a")
    val vitaminA: String = "",
    @SerializedName("deworming")
    val deworming: String = ""
)

data class Vaccine(
    val name: String = "",
    val dateTaken: String = "",
    val isInjection: Boolean = false
)


