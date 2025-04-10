package com.github.joelarmah.babyvaccination.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.github.joelarmah.babyvaccination.data.local.database.entity.VaccinationScheduleEntity

@Dao
interface VaccinationScheduleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vaccines: List<VaccinationScheduleEntity>)

    @Query("SELECT * FROM vaccination_schedules")
    suspend fun getAllVaccines(): List<VaccinationScheduleEntity>

    suspend fun updateVaccinationDate(vaccinationScheduleId: Int, newDate: String) {

    }
}