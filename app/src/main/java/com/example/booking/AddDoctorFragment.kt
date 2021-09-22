package com.example.booking

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.booking.databinding.FragmentAddDoctorBinding
import kotlinx.android.synthetic.main.fragment_add_doctor.*
import kotlinx.android.synthetic.main.fragment_add_doctor.view.*

class AddDoctorFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_doctor, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.add_btn.setOnClickListener{
            insertDataToDataBase()
        }
        return view
    }

    private fun insertDataToDataBase() {

        val name = edt_UserName.text.toString()
        val address = edt_UserAddress.text.toString()
        val speciality = edt_Speciality.text.toString()

        if (inputCheck(name, address, speciality)) {
            val user = User(0, name, address, speciality)
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addDoctorFragment_to_doctorsFragment)

        } else {
            Toast.makeText(requireContext(), "Please Fill All Fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String, address: String, speciality: String): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(address) && TextUtils.isEmpty(
            speciality
        ))

    }


}