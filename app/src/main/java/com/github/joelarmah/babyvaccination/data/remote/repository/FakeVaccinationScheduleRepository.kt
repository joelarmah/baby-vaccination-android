package com.github.joelarmah.babyvaccination.data.remote.repository

import android.content.Context
import com.github.joelarmah.babyvaccination.data.local.database.entity.VaccinationScheduleEntity

class FakeVaccinationScheduleRepository: VaccinationScheduleRepository {
    override suspend fun generateVaccinationSchedule(
        context: Context,
        dob: String,
    ): List<VaccinationScheduleEntity> {
        TODO("Not yet implemented")
    }
}