package com.misha_cherdak.kvantorium_rasp.presenter.groups.items

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Group
import com.misha_cherdak.kvantorium_rasp.databinding.ItemGroupBinding

fun groupsAdapterItemDelegate(
    onClick: (Group) -> Unit
) = adapterDelegateViewBinding<Group, Group, ItemGroupBinding>(
    viewBinding = { layoutInflater, parent ->
        ItemGroupBinding.inflate(layoutInflater, parent, false)
    },
    block = {
        binding.root.setOnClickListener { onClick(item) }

        bind {
            binding.tvGroupName.text = item.name_gryp
        }
    }

)
