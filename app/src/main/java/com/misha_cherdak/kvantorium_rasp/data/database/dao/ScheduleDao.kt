package com.misha_cherdak.kvantorium_rasp.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Group
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Prep
import com.misha_cherdak.kvantorium_rasp.data.database.entity.relations.FullScheduleInfo

@Dao
interface ScheduleDao {

    @Transaction
    @Query("SELECT * FROM rasp ORDER BY id_rasp ASC")
    suspend fun readAllSchedules(): List<FullScheduleInfo>

    @Transaction
    @Query(
        """
        SELECT * FROM rasp_for_gryp 
        JOIN rasp ON id_forgein_rasp = id_rasp
        WHERE id_forgein_gryp = :groupId
        ORDER BY id_rasp_for_gryp ASC
        """
    )
    suspend fun getSchedulesByGroup(groupId: Int): List<FullScheduleInfo>

    @Transaction
    @Query(
        """
        SELECT * FROM rasp
        WHERE id_forgein_prep = :teacherId
        ORDER BY id_forgein_prep ASC
        """
    )
    suspend fun getScheduleByTeacher(teacherId: Int): List<FullScheduleInfo>

    @Query("SELECT * FROM gryp ORDER BY id_gryp ASC")
    suspend fun getAllGroups(): List<Group>

    @Query("SELECT * FROM prep ORDER BY id_prep ASC")
    suspend fun getAllTeachers(): List<Prep>

}
