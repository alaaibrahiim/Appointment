package com.example.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.booking.databinding.FragmentLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    private lateinit var user: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = FirebaseAuth.getInstance()
        //   checkIfUserLogged()
        binding.btnLogin.setOnClickListener {
            signinfun()

        }
        binding.btnRegister.setOnClickListener {
            var action = LoginFragmentDirections.actionLoginFragmentToSignUpFragment()
            findNavController().navigate(action)
        }


    }

    /*
        private fun checkIfUserLogged() {
           if(user.currentUser!=null){
               var action = LoginFragmentDirections.actionLoginFragmentToCategoriesFragment()
               findNavController().navigate(action)
           }
        }
    */
    private fun signinfun() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.text.toString()


        if (binding.etEmail.text.toString().isNotEmpty() && binding.etPassword.text.toString()
                .isNotEmpty()
        ) {
            user.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { mTask ->
                    if (mTask.isSuccessful) {
                        Toast.makeText(context, "Logged as $email", Toast.LENGTH_LONG)
                            .show()
                        var action =
                            LoginFragmentDirections.actionLoginFragmentToAuthenticationFragment()
                        findNavController().navigate(action)
                    } else {
                        Toast.makeText(
                            context,
                            "Login Failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

        } else if (binding.etEmail.text.toString().isEmpty()) {
            binding.etEmail.error = "Email Required"


        } else if (binding.etPassword.text.toString().isEmpty()) {
            binding.etPassword.error = "Password Required"

        }

    }


}






