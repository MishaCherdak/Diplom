package com.misha_cherdak.kvantorium_rasp.presenter.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.misha_cherdak.kvantorium_rasp.R
import com.misha_cherdak.kvantorium_rasp.databinding.FragmentStudGroupBinding
import com.misha_cherdak.kvantorium_rasp.presenter.groups.items.groupsAdapterItemDelegate
import com.misha_cherdak.kvantorium_rasp.presenter.schedule.ARG_VIEW_TYPE
import com.misha_cherdak.kvantorium_rasp.presenter.schedule.ScheduleViewType

class GroupsFragment : Fragment() {

    private lateinit var _binding: FragmentStudGroupBinding
    private val binding get() = _binding

    private val viewModel: GroupsViewModel by viewModels()

    // Объявляем адаптер для списка групп
    private val groupAdapter = ListDelegationAdapter(
        groupsAdapterItemDelegate { viewModel.onGroupClick(it) }
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
        // Поиск
        binding.searchView.queryHint = "Введите номер группы"
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // nothig
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.onQueryTextChange(newText)
                return true
            }
        })

        viewModel.groups.observe(viewLifecycleOwner) {
            groupAdapter.items = it
            groupAdapter.notifyDataSetChanged()
        }
        viewModel.eventOpenGroupSchedule.observe(viewLifecycleOwner) {
            openGroupSchedule(it)
        }
    }

    private fun openGroupSchedule(groupId: Int) {
        findNavController().navigate(
            resId = R.id.action_stud_group_Fragment_to_scheduleFragment,
            args = bundleOf(ARG_VIEW_TYPE to ScheduleViewType.ByGroup(groupId))
        )
    }

}
