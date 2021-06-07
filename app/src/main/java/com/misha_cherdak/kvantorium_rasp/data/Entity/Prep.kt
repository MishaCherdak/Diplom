package com.misha_cherdak.kvantorium_rasp.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "prep")
data class Prep(
    @PrimaryKey val id_prep: Int,
    val surname_prep: String,
    val name_prep: String,
    val secname_prep: String
)