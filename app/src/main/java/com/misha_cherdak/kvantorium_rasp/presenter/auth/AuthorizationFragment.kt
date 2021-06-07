package com.misha_cherdak.kvantorium_rasp.presenter.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.misha_cherdak.kvantorium_rasp.R
import kotlinx.android.synthetic.main.fragment_autorize.*

class AuthorizationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_autorize, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAuth.setOnClickListener {
            findNavController().navigate(R.id.action_autorizeFragment_to_admin_groupFragment)
        }
    }

}