package com.github.joelarmah.babyvaccination.data.remote.repository

import com.github.joelarmah.babyvaccination.data.local.database.dao.VaccinationDao
import com.github.joelarmah.babyvaccination.data.local.database.entity.VaccinationEntity
import kotlinx.coroutines.flow.Flow

class VaccinationRepository(private val vaccinationDao: VaccinationDao)  {

    fun getAllVaccinations(): Flow<List<VaccinationEntity>> = vaccinationDao.getAllVaccinations()

    fun getVaccinationById(id: Int): Flow<VaccinationEntity> = vaccinationDao.getVaccinationById(id)

    suspend fun insertVaccination(vaccination: VaccinationEntity) = vaccinationDao.insert(vaccination)

    suspend fun updateVaccination(vaccination: VaccinationEntity) = vaccinationDao.update(vaccination)

    suspend fun deleteVaccination(vaccination: VaccinationEntity) = vaccinationDao.delete(vaccination)

}