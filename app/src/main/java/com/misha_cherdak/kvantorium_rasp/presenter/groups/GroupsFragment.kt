package com.misha_cherdak.kvantorium_rasp.presenter.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.misha_cherdak.kvantorium_rasp.data.database.entity.Group
import com.misha_cherdak.kvantorium_rasp.databinding.FragmentStudGroupBinding
import com.misha_cherdak.kvantorium_rasp.presenter.groups.items.groupsAdapterItemDelegate

class GroupsFragment : Fragment() {

    private lateinit var _binding: FragmentStudGroupBinding
    private val binding get() = _binding

    private val viewModel: GroupsViewModel by viewModels()

    // Объявляем адаптер для списка групп
    private val groupAdapter = ListDelegationAdapter(
        groupsAdapterItemDelegate { onGroupClick(it) }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudGroupBinding.inflate(inflater, container, false)
        return _binding.root
    }

    // Манипуляции с адаптером
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvGroups.adapter = groupAdapter

        viewModel.groups.observe(viewLifecycleOwner) {
            groupAdapter.items = it
            groupAdapter.notifyDataSetChanged()
        }
    }

    private fun onGroupClick(group: Group) {

    }

}
