package com.misha_cherdak.kvantorium_rasp.presenter.teacher

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.misha_cherdak.kvantorium_rasp.R
import com.misha_cherdak.kvantorium_rasp.databinding.FragmentPrepBinding
import com.misha_cherdak.kvantorium_rasp.presenter.schedule.ARG_VIEW_TYPE
import com.misha_cherdak.kvantorium_rasp.presenter.schedule.ScheduleViewType
import com.misha_cherdak.kvantorium_rasp.presenter.teacher.items.teachersAdapterItemDelegate

class TeachersFragment : Fragment() {

    private lateinit var _binding: FragmentPrepBinding
    private val binding get() = _binding

    private val viewModel: TeachersViewModel by viewModels()

    private val teacherAdapter = ListDelegationAdapter(
        teachersAdapterItemDelegate { viewModel.onTeacherClick(it) }
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPrepBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTeachers.adapter = teacherAdapter

        viewModel.teachers.observe(viewLifecycleOwner) {
            teacherAdapter.items = it
            teacherAdapter.notifyDataSetChanged()
        }
        viewModel.eventOpenTeacherSchedule.observe(viewLifecycleOwner) {
            openTeacherSchedule(it)
        }
    }

    private fun openTeacherSchedule(teacherId: Int) {
        findNavController().navigate(
            resId = R.id.action_prepFragment_to_scheduleFragment,
            args = bundleOf(ARG_VIEW_TYPE to ScheduleViewType.ByTeacher(teacherId))
        )
    }
}