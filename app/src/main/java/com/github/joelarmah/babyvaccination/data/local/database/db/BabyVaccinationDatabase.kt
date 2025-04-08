package com.github.joelarmah.babyvaccination.data.local.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.joelarmah.babyvaccination.R
import com.github.joelarmah.babyvaccination.data.local.database.dao.UserDao
import com.github.joelarmah.babyvaccination.data.local.database.dao.VaccinationDao
import com.github.joelarmah.babyvaccination.data.local.database.entity.UserEntity
import com.github.joelarmah.babyvaccination.data.local.database.entity.VaccinationEntity
import java.util.Locale

@Database(
    entities = [
        UserEntity::class,
        VaccinationEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class BabyVaccinationDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun vaccinationDao(): VaccinationDao
    // abstract fun vaccinationDao(): VaccinationDao

    companion object {
        @Volatile
        private var INSTANCE: BabyVaccinationDatabase? = null

        fun getDatabase(context: Context): BabyVaccinationDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BabyVaccinationDatabase::class.java,
                    "${context.getString(R.string.app_name).lowercase(Locale.ROOT)}_db"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}