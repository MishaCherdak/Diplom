package com.misha_cherdak.kvantorium_rasp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gryp")
data class Group(
    @PrimaryKey val id_gryp: Int,
    val name_gryp: String
)