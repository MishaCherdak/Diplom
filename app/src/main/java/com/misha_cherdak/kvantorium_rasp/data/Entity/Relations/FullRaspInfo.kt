package com.misha_cherdak.kvantorium_rasp.data.Entity.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.misha_cherdak.kvantorium_rasp.data.Entity.Audit
import com.misha_cherdak.kvantorium_rasp.data.Entity.Day
import com.misha_cherdak.kvantorium_rasp.data.Entity.Predmet
import com.misha_cherdak.kvantorium_rasp.data.Entity.Prep
import com.misha_cherdak.kvantorium_rasp.data.Rasp

data class FullRaspInfo (

    @Embedded val rasp: Rasp,

    @Relation(
        parentColumn = "id_forgein_predmet",
        entityColumn = "id_predmet"
    )
    val predmet: Predmet,

    @Relation(
        parentColumn = "id_forgein_prep",
        entityColumn = "id_prep"
    )
    val prep: Prep,

    @Relation(
        parentColumn = "id_forgein_audit",
        entityColumn = "id_audit"
    )
    val audit: Audit,

    @Relation(
        parentColumn = "id_forgein_day",
        entityColumn = "id_day"
    )
    val day: Day
)