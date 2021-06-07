package com.misha_cherdak.kvantorium_rasp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Group
import com.misha_cherdak.kvantorium_rasp.data.database.entity.GroupSchedule
import com.misha_cherdak.kvantorium_rasp.data.database.entity.relations.FullScheduleInfo

@Dao
interface RaspDao {

    @Transaction
    @Query("SELECT * FROM rasp ORDER BY id_rasp ASC")
    suspend fun readAllSchedule(): List<FullScheduleInfo>

    @Transaction
    @Query("SELECT * FROM rasp_for_gryp ORDER BY id_rasp_for_gryp ASC")
    suspend fun readGroupSchedule(): List<GroupSchedule>

    @Query("SELECT * FROM gryp ORDER BY id_gryp ASC")
    suspend fun readAllGroups(): List<Group>

}
