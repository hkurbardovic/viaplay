package com.hkurbardovic.viaplay.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hkurbardovic.viaplay.database.daos.SectionDao
import com.hkurbardovic.viaplay.database.daos.SectionDetailsDao
import com.hkurbardovic.viaplay.database.models.Section
import com.hkurbardovic.viaplay.database.models.SectionDetails

/**
 * The Room database for this app
 */
@Database(entities = [Section::class, SectionDetails::class], version = 1, exportSchema = false)
abstract class ViaplayDatabase : RoomDatabase() {

    abstract fun sectionDao(): SectionDao

    abstract fun sectionDetailsDao(): SectionDetailsDao

    companion object {

        private const val DB_NAME = "viaplay"

        // For Singleton instantiation
        @Volatile
        private var instance: ViaplayDatabase? = null

        fun getInstance(context: Context): ViaplayDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): ViaplayDatabase {
            return Room.databaseBuilder(context, ViaplayDatabase::class.java, DB_NAME).build()
        }
    }
}