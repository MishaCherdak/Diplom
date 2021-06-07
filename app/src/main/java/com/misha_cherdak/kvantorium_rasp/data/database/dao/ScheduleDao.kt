package com.misha_cherdak.kvantorium_rasp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Group
import com.misha_cherdak.kvantorium_rasp.data.database.entity.relations.FullScheduleInfo
import com.misha_cherdak.kvantorium_rasp.data.database.entity.relations.GroupScheduleInfo

@Dao
interface ScheduleDao {

    @Transaction
    @Query("SELECT * FROM rasp ORDER BY id_rasp ASC")
    suspend fun readAllSchedules(): List<FullScheduleInfo>

    @Transaction
    @Query("SELECT * FROM rasp_for_gryp WHERE id_forgein_gryp = :groupId ORDER BY id_rasp_for_gryp ASC")
    suspend fun getGroupSchedule(groupId: Int): List<GroupScheduleInfo>

    @Query("SELECT * FROM gryp ORDER BY id_gryp ASC")
    suspend fun getAllGroups(): List<Group>

}
