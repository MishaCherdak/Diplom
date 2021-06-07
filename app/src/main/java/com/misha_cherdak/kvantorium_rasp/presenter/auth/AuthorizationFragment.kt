package com.misha_cherdak.kvantorium_rasp.presenter.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.misha_cherdak.kvantorium_rasp.R
import com.misha_cherdak.kvantorium_rasp.databinding.FragmentAutorizeBinding

class AuthorizationFragment : Fragment() {

    private lateinit var _binding: FragmentAutorizeBinding
    private val binding: FragmentAutorizeBinding get() = _binding

    private val authorizeModel: AuthorizationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAutorizeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        authorizeModel.eventErrorAuth.observe(viewLifecycleOwner) {
            binding.etLogin.error = "Invalid login"
            binding.etPassword.error = "Invalid password"
        }
        authorizeModel.eventOpenSome.observe(viewLifecycleOwner) {
            binding.etLogin.error = null
            binding.etPassword.error = null
        }

        binding.btnAuth.setOnClickListener {
            authorizeModel.onAuthClick(
                login = binding.etLogin.text.toString(),
                password = binding.etPassword.text.toString()
            )
//            findNavController().navigate(R.id.action_autorizeFragment_to_admin_groupFragment)
        }
    }

}