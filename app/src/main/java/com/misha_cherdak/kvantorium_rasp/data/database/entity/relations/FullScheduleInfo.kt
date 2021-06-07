package com.misha_cherdak.kvantorium_rasp.data.database.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.misha_cherdak.kvantorium_rasp.data.database.entity.*

data class FullScheduleInfo (
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
    val day: Day,

    @Relation(
        entity = GroupSchedule::class,
        parentColumn = "id_rasp",
        entityColumn = "id_forgein_rasp"
    )
    val groups: List<GroupInfo>
)