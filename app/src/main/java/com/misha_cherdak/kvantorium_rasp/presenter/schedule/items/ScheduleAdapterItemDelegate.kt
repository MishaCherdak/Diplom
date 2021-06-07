package com.misha_cherdak.kvantorium_rasp.presenter.schedule.items

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.misha_cherdak.kvantorium_rasp.data.database.entity.relations.GroupScheduleInfo
import com.misha_cherdak.kvantorium_rasp.databinding.ItemScheduleBinding

fun scheduleAdapterItemDelegate() =
    adapterDelegateViewBinding<GroupScheduleInfo, GroupScheduleInfo, ItemScheduleBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemScheduleBinding.inflate(layoutInflater, parent, false)
        },
        block = {
            bind {

            }
        }
    )
