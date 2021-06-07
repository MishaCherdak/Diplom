package com.misha_cherdak.kvantorium_rasp.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "predmet")
data class Predmet(
    @PrimaryKey val id_predmet: Long,
    val name_predmet: String
)