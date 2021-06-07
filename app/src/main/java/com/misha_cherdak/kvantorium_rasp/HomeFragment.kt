package com.misha_cherdak.kvantorium_rasp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val group_btn = view.findViewById<Button>(R.id.rasp_group_btn)
        group_btn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_stud_group_Fragment)
        }

        val prep_btn = view.findViewById<Button>(R.id.rasp_prep_btn)
        prep_btn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_prepFragment)
        }

        val admin_btn = view.findViewById<Button>(R.id.autorize_admin_btn)
        admin_btn.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_autorizeFragment)
        }
    }

}