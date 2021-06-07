package com.misha_cherdak.kvantorium_rasp.data.database.entity.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Group
import com.misha_cherdak.kvantorium_rasp.data.database.entity.GroupSchedule
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Rasp

data class GroupScheduleInfo(
    @Embedded val groupSchedule: GroupSchedule,

    @Relation(
        parentColumn = "id_forgein_gryp",
        entityColumn = "id_gryp"
    )
    val group: Group,

    @Relation(
        entity = Rasp::class,
        parentColumn = "id_forgein_rasp",
        entityColumn = "id_rasp"
    )
    val schedule: List<FullScheduleInfo>
)
