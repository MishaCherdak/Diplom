package com.misha_cherdak.kvantorium_rasp.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.misha_cherdak.kvantorium_rasp.data.database.dao.ScheduleDao
import com.misha_cherdak.kvantorium_rasp.data.database.entity.*

@Database(
    entities = [
        Audit::class,
        Day::class,
        Group::class,
        Predmet::class,
        Prep::class,
        Rasp::class,
        GroupSchedule::class
    ],
    exportSchema = false,
    version = 1
)
abstract class ScheduleDatabase : RoomDatabase() {

    abstract fun scheduleDao(): ScheduleDao

    companion object {
        @Volatile
        private var INSTANCE: ScheduleDatabase? = null

        fun gatDatabase(context: Context): ScheduleDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        ScheduleDatabase::class.java,
                        "rasp_database"
                    )
                    .createFromAsset("rasp_database")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}