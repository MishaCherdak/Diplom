package com.misha_cherdak.kvantorium_rasp.presenter.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.misha_cherdak.kvantorium_rasp.R
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_home, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnShowGroupSchedule.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_stud_group_Fragment)
        }

        btnShowTeacherSchedule.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_prepFragment)
        }
    }

}