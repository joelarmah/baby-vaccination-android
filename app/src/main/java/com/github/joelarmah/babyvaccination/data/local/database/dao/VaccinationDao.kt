package com.github.joelarmah.babyvaccination.data.local.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.github.joelarmah.babyvaccination.data.local.database.entity.VaccinationEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VaccinationDao {
    @Insert
    suspend fun insert(vaccination: VaccinationEntity)

    @Update
    suspend fun update(vaccination: VaccinationEntity)

    @Delete
    suspend fun delete(vaccination: VaccinationEntity)

    @Query("SELECT * FROM vaccinations")
    fun getAllVaccinations(): Flow<List<VaccinationEntity>>

    @Query("SELECT * FROM vaccinations WHERE id = :id")
    fun getVaccinationById(id: Int): Flow<VaccinationEntity>

}