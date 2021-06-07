package com.misha_cherdak.kvantorium_rasp.presenter.schedule

import android.app.Application
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.misha_cherdak.kvantorium_rasp.databinding.FragmentScheduleBinding
import com.misha_cherdak.kvantorium_rasp.presenter.schedule.items.scheduleAdapterItemDelegate

const val ARG_VIEW_TYPE = "presenter.schedule.ScheduleFragmentKt.ARG_VIEW_TYPE"

class ScheduleFragment : Fragment() {

    private lateinit var _binding: FragmentScheduleBinding
    private val binding: FragmentScheduleBinding get() = _binding

    private val scheduleAdapter = ListDelegationAdapter(scheduleAdapterItemDelegate())
    private var currentDayView: TextView? = null

    private val viewModel: ScheduleViewModel by viewModels {
        ScheduleViewModelFactory(
            applicationProvider = { requireActivity().application },
            scheduleViewType = requireArguments().getParcelable(ARG_VIEW_TYPE)!!
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvSchedule.adapter = scheduleAdapter

        binding.tvMonday.bindDayClick()
        binding.tvTuesday.bindDayClick()
        binding.tvWednesday.bindDayClick()
        binding.tvThursday.bindDayClick()
        binding.tvFriday.bindDayClick()
        binding.tvSaturday.bindDayClick()
        binding.tvSunday.bindDayClick()

        viewModel.schedule.observe(viewLifecycleOwner) {
            scheduleAdapter.items = it
            scheduleAdapter.notifyDataSetChanged()
        }

        viewModel.currentDay.observe(viewLifecycleOwner) { dayId ->
            currentDayView?.setBackgroundColor(Color.TRANSPARENT)
            currentDayView = binding.clDaysOfWeek.findViewWithTag(dayId.toString())
            currentDayView?.setBackgroundColor(
                ContextCompat.getColor(requireContext(), android.R.color.holo_blue_bright)
            )
        }
    }

    private fun TextView.bindDayClick() {
        setOnClickListener { viewModel.onDayClick((this.tag as String).toInt()) }
    }

    private class ScheduleViewModelFactory(
        private val applicationProvider: () -> Application,
        private val scheduleViewType: ScheduleViewType
    ) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            ScheduleViewModel(applicationProvider.invoke(), scheduleViewType) as T
    }

}
