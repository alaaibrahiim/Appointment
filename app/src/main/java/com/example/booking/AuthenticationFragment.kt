package com.example.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.booking.databinding.FragmentAuthenticationBinding

class AuthenticationFragment : Fragment() {

    lateinit var binding: FragmentAuthenticationBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAuthenticationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAdmin.setOnClickListener{
            val action = AuthenticationFragmentDirections.actionAuthenticationFragmentToAdminValidationFragment()
            findNavController().navigate(action)
        }
        binding.btnUser.setOnClickListener{
            val action = AuthenticationFragmentDirections.actionAuthenticationFragmentToCategoriesFragment()
            findNavController().navigate(action)
        }

    }


}