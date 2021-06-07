package com.misha_cherdak.kvantorium_rasp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "admin")
data class Admin(
    @PrimaryKey val id_admin:Int,
    val login: String,
    val Pass: String
)