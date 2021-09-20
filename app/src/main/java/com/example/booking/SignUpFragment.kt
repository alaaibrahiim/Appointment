package com.example.booking

import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.booking.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import java.util.regex.Matcher
import java.util.regex.Pattern

class SignUpFragment : Fragment() {
    lateinit var binding: FragmentSignUpBinding
    private lateinit var user:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = FirebaseAuth.getInstance()
        binding.btnSignup.setOnClickListener {

            if (validate()) {
                val email = binding.edtEmail.text.toString()
                val password = binding.edtPassword.text.toString()

                user.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
                    task->
                    if (task.isSuccessful){
                        Toast.makeText(context, "Account created successfully", Toast.LENGTH_LONG).show()
                        var action=SignUpFragmentDirections.actionSignUpFragmentToLoginFragment()
                        findNavController().navigate(action)
                    }else{
                        Toast.makeText(context, "$email is already used", Toast.LENGTH_SHORT).show()
                    }
                }

            }


        }
        binding.checkBox.setOnClickListener {
            if (binding.checkBox.isChecked) {
                binding.edtPassword.inputType = 1
            } else
                binding.edtPassword.inputType =
                    InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

        binding.edtEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(binding.edtEmail.text.toString())
                        .matches()
                )
                    binding.btnSignup.isEnabled = true
                else {
                    binding.btnSignup.isEnabled = false
                    binding.edtEmail.setError("Invalid Email")
                }
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
        binding.edtPhone.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (mobileValidate(binding.edtPhone.text.toString()))
                    binding.btnSignup.isEnabled = true
                else {
                    binding.btnSignup.isEnabled = false
                    binding.edtPhone.setError("Invalid Phone Number")
                }

            }

            override fun afterTextChanged(s: Editable?) {

            }
        })
    }

    private fun mobileValidate(text: String): Boolean {
        var p: Pattern = Pattern.compile("[1][0-9]{9}")
        var m: Matcher = p.matcher(text)
        return m.matches()
    }

    private fun validate(): Boolean {
        if (binding.edtFullname.text.toString().isEmpty()) {
            binding.edtFullname.error = "UserName Required"
            return false
        } else if (binding.edtEmail.text.toString().isEmpty()) {
            binding.edtEmail.error = "Email Required"
            return false
        } else if (binding.edtPhone.text.toString().isEmpty()) {
            binding.edtPhone.error = "Phone Number Required"
            return false
        } else if (binding.edtPassword.text.toString().isEmpty()) {
            binding.edtPassword.error = "Password Required"
            return false
        }else if(binding.edtPassword.length()<6){
            binding.edtPassword.error="Password must be > 6 characters"
            return false
        }
        return true
    }

}