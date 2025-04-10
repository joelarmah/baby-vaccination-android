package com.github.joelarmah.babyvaccination.di

import com.github.joelarmah.babyvaccination.data.local.database.dao.VaccinationScheduleDao
import com.github.joelarmah.babyvaccination.data.remote.repository.VaccinationScheduleRepository
import com.github.joelarmah.babyvaccination.data.remote.repository.VaccinationScheduleRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideVaccinationScheduleRepository(
        vaccinationScheduleDao: VaccinationScheduleDao
    ): VaccinationScheduleRepository {
        return VaccinationScheduleRepositoryImpl(vaccinationScheduleDao)
    }

}