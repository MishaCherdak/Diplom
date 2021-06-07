package com.misha_cherdak.kvantorium_rasp.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rasp_for_gryp")
data class Rasp_for_gryp(
    @PrimaryKey(autoGenerate = true) val id_rasp_for_gryp: Long,
    val id_forgein_gryp: Int,
    val id_forgein_rasp: Long
)