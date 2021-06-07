package com.misha_cherdak.kvantorium_rasp.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gryp")
data class Gryp(
    @PrimaryKey val id_gryp: Int,
    val name_gryp: String
)