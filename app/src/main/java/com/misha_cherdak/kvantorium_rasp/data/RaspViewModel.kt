package com.misha_cherdak.kvantorium_rasp.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.misha_cherdak.kvantorium_rasp.data.database.ScheduleDatabase

class RaspViewModel(application: Application) : AndroidViewModel(application) {

    private val scheduleDao by lazy { ScheduleDatabase.gatDatabase(application).scheduleDao() }

}
