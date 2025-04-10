package com.github.joelarmah.babyvaccination.data.local.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.github.joelarmah.babyvaccination.R
import com.github.joelarmah.babyvaccination.data.local.database.converters.Converters
import com.github.joelarmah.babyvaccination.data.local.database.dao.UserDao
import com.github.joelarmah.babyvaccination.data.local.database.dao.VaccinationScheduleDao
import com.github.joelarmah.babyvaccination.data.local.database.entity.UserEntity
import com.github.joelarmah.babyvaccination.data.local.database.entity.VaccinationScheduleEntity
import java.util.Locale

@Database(
    entities = [
        UserEntity::class,
        VaccinationScheduleEntity::class
    ],
    version = 1,
    exportSchema = false
)

@TypeConverters(
    Converters::class
)
abstract class BabyVaccinationDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun vaccinationScheduleDao(): VaccinationScheduleDao

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