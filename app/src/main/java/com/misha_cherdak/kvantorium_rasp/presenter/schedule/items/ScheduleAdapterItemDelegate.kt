package com.misha_cherdak.kvantorium_rasp.presenter.schedule.items

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.misha_cherdak.kvantorium_rasp.databinding.ItemScheduleBinding
import com.misha_cherdak.kvantorium_rasp.presenter.schedule.entity.ScheduleItem

fun scheduleAdapterItemDelegate() =
    adapterDelegateViewBinding<ScheduleItem, ScheduleItem, ItemScheduleBinding>(
        viewBinding = { layoutInflater, parent ->
            ItemScheduleBinding.inflate(layoutInflater, parent, false)
        },
        block = {
            bind {
                binding.tvLessonName.text = item.lessonName
                binding.tvDescription.text = item.description
                binding.tvAuditName.text = item.auditory
                binding.tvTime.text = item.time
            }
        }
    )
