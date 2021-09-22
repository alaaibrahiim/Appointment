package com.example.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.booking.databinding.FragmentAdminValidationBinding

class AdminValidationFragment : Fragment() {

    private val validationPassword = 2468
    lateinit var binding: FragmentAdminValidationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdminValidationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Date Validation
        fun validate(): Boolean {
            if (binding.edtVerification.text.toString().isNullOrEmpty()) {
                binding.edtVerification.requestFocus()
                binding.edtVerification.error = "Password should not be blank"
                return false
            }
            if (binding.edtVerification.text.toString() != validationPassword.toString()) {
                binding.edtVerification.requestFocus()
                binding.edtVerification.error = "Invalid Password"

                return false
            }
            return true

        }




        binding.btnDone2.setOnClickListener {
            if (!validate()) {
                Toast.makeText(context, "Enter the right password", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(context, "Successful password", Toast.LENGTH_LONG).show()
                val action= AdminValidationFragmentDirections.actionAdminValidationFragmentToDoctorsFragment()
                findNavController().navigate(action)
            }

        }


    }
}