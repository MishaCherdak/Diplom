package com.misha_cherdak.kvantorium_rasp.presenter.teacher.items

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Prep
import com.misha_cherdak.kvantorium_rasp.data.database.entity.fullName
import com.misha_cherdak.kvantorium_rasp.databinding.ItemTeacherBinding

fun teachersAdapterItemDelegate(
    onClick: (Prep) -> Unit
) = adapterDelegateViewBinding<Prep, Prep, ItemTeacherBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemTeacherBinding.inflate(layoutInflater, parent, false)
    },
    block = {
        binding.root.setOnClickListener { onClick(item) }

        bind {
            binding.tvTeacherFIO.text = item.fullName
        }
    }
)