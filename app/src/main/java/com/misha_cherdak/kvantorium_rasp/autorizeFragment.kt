package com.misha_cherdak.kvantorium_rasp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_home.*

class autorizeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_autorize, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val amdin_group_btn = view.findViewById<Button>(R.id.autor_btn)
        amdin_group_btn.setOnClickListener {
            findNavController().navigate(R.id.action_autorizeFragment_to_admin_groupFragment)
        }
    }

}