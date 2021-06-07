package com.misha_cherdak.kvantorium_rasp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "rasp")
data class Rasp (
    @PrimaryKey(autoGenerate = true) val id_rasp: Long,
    val id_forgein_predmet: Long,
    val id_forgein_prep: Long,
    val id_forgein_audit: Long,
    val time: String,
    val id_forgein_day: Int
)
