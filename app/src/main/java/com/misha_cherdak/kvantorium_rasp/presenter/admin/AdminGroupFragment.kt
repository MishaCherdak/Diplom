package com.misha_cherdak.kvantorium_rasp.presenter.admin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.misha_cherdak.kvantorium_rasp.R
import com.misha_cherdak.kvantorium_rasp.databinding.FragmentAdminGroupBinding

class AdminGroupFragment : Fragment() {

    private lateinit var _binding: FragmentAdminGroupBinding
    private val binding: FragmentAdminGroupBinding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAdminGroupBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}
