package com.misha_cherdak.kvantorium_rasp.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "audit")
data class Audit(
    @PrimaryKey val id_audit: Int,
    val name_audit: String
)