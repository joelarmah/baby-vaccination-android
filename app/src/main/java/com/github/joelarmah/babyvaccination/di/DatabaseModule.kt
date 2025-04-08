package com.github.joelarmah.babyvaccination.di

import android.content.Context
import com.github.joelarmah.babyvaccination.data.local.database.db.BabyVaccinationDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): BabyVaccinationDatabase {
        return BabyVaccinationDatabase.getDatabase(context)
    }

    @Provides
    fun provideUserDao(database: BabyVaccinationDatabase) = database.userDao()

    @Provides
    fun provideVaccinationDao(database: BabyVaccinationDatabase) = database.vaccinationDao()

}