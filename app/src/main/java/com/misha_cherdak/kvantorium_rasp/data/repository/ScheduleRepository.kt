package com.misha_cherdak.kvantorium_rasp.data.repository

import com.misha_cherdak.kvantorium_rasp.data.database.dao.ScheduleDao
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Group

class ScheduleRepository(
    private val scheduleDao: ScheduleDao
) {

    suspend fun readAllGroups(): List<Group> = scheduleDao.readAllGroups()

}