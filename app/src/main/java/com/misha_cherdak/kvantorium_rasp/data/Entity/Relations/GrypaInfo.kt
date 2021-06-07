package com.misha_cherdak.kvantorium_rasp.data.Entity.Relations

import androidx.room.Embedded
import androidx.room.Relation
import com.misha_cherdak.kvantorium_rasp.data.Entity.Gryp
import com.misha_cherdak.kvantorium_rasp.data.Entity.Rasp_for_gryp
import com.misha_cherdak.kvantorium_rasp.data.Rasp


data class GrypaInfo (
    @Embedded val raspForGryp: Rasp_for_gryp,

    @Relation(
        parentColumn = "id_forgein_gryp",
        entityColumn = "id_gryp"
    )
    val gryp: Gryp,

    @Relation(
        parentColumn = "id_forgein_rasp",
        entityColumn = "id_rasp"
    )
    val rasp: Rasp
)