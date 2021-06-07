package com.misha_cherdak.kvantorium_rasp.presenter.groups

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.misha_cherdak.kvantorium_rasp.databinding.FragmentStudGroupBinding

class GroupsFragment : Fragment() {

    private lateinit var _binding: FragmentStudGroupBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStudGroupBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvGroups
    }

}
