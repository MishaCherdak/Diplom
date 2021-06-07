package com.misha_cherdak.kvantorium_rasp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.misha_cherdak.kvantorium_rasp.data.Entity.Gryp
import com.misha_cherdak.kvantorium_rasp.data.Entity.Rasp_for_gryp
import com.misha_cherdak.kvantorium_rasp.data.Entity.Relations.FullRaspInfo

@Dao
interface RaspDao {

    @Transaction
    @Query("SELECT * FROM rasp ORDER BY id_rasp ASC")
    fun readlAllRasp(): LiveData<List<FullRaspInfo>>

    @Transaction
    @Query ("SELECT * FROM rasp_for_gryp ORDER BY id_rasp_for_gryp ASC")
    fun readRaspForGryp(): LiveData<List<Rasp_for_gryp>>

    @Query ("SELECT * FROM gryp ORDER BY id_gryp ASC")
    fun readAllGryp(): LiveData<List<Gryp>>


}