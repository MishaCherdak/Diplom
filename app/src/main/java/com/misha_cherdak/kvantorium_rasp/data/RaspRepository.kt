package com.misha_cherdak.kvantorium_rasp.data

import androidx.lifecycle.LiveData
import com.misha_cherdak.kvantorium_rasp.data.Entity.Gryp

class RaspRepository(private val raspDao: RaspDao) {

    val readAllGryp: LiveData<List<Gryp>> = raspDao.readAllGryp()


}