package com.misha_cherdak.kvantorium_rasp.presenter.schedule

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.misha_cherdak.kvantorium_rasp.databinding.FragmentScheduleBinding

const val ARG_VIEW_TYPE = "presenter.schedule.ScheduleFragmentKt.ARG_VIEW_TYPE"

class ScheduleFragment : Fragment() {

    private lateinit var _binding: FragmentScheduleBinding
    private val binding: FragmentScheduleBinding get() = _binding

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
        viewModel.schedule.observe(viewLifecycleOwner) {

        }
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
