package com.misha_cherdak.kvantorium_rasp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.misha_cherdak.kvantorium_rasp.data.Entity.*
import com.misha_cherdak.kvantorium_rasp.data.Entity.Relations.FullRaspInfo
import com.misha_cherdak.kvantorium_rasp.data.Entity.Relations.GrypaInfo

@Database(entities = [Admin::class, Audit::class, Day::class, Gryp::class, Predmet::class, Prep::class, Rasp::class, Rasp_for_gryp::class],
views = [FullRaspInfo::class, GrypaInfo::class], version = 1)
abstract class RaspDatabase: RoomDatabase() {

    abstract fun raspDao(): RaspDao

    companion object{
        @Volatile
        private var INSTANCE: RaspDatabase? = null

        fun gatDatabase(context: Context): RaspDatabase{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RaspDatabase::class.java,
                    "rasp_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}