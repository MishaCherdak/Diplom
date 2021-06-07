package com.misha_cherdak.kvantorium_rasp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "day")
data class Day(
    @PrimaryKey val id_day: Int,
    val name_day: String
)