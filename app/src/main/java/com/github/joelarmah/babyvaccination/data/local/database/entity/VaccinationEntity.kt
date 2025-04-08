package com.github.joelarmah.babyvaccination.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vaccinations")
data class VaccinationEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "vaccine_name") val vaccineName: String,
    @ColumnInfo(name = "date_administered") val dateAdministered: String,
    @ColumnInfo(name = "baby_name") val babyName: String
)
