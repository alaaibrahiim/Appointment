package com.example.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.booking.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
   lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnLogin.setOnClickListener {
            val Email = binding.etEmail.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            if (Email.isEmpty()) {
                binding.etEmail.error = "Email must not be empty"
                return@setOnClickListener
            } else if (password.isEmpty()) {
                binding.etPassword.error = "Password must not be empty"
                return@setOnClickListener
            } else {
                Toast.makeText(
                    context
                    , ("validation completed"),
                    Toast.LENGTH_SHORT
                ).show()
                if (!binding.etEmail.text.toString().isNullOrEmpty() && !binding.etPassword.text.toString()
                        .isNullOrEmpty()
                ) {
                    if (!binding.etEmail.text.equals(Email) && binding.etPassword.text.toString()
                            .equals(password)
                    ) {
                        Toast.makeText(context, "LoginSuccessful", Toast.LENGTH_LONG).show()

                    }
                }

                var action=LoginFragmentDirections.actionLoginFragmentToCategoriesFragment()
                findNavController().navigate(action)
            }
            binding.btnRegister.setOnClickListener {

                var action=LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
                findNavController().navigate(action)
            }


        }

    }

}