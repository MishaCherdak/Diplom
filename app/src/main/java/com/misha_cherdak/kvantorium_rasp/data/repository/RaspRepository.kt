package com.misha_cherdak.kvantorium_rasp.data.repository

import com.misha_cherdak.kvantorium_rasp.data.database.dao.RaspDao
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Group

class RaspRepository(
    private val raspDao: RaspDao
) {

    suspend fun readAllGroups(): List<Group> = raspDao.readAllGroups()

}