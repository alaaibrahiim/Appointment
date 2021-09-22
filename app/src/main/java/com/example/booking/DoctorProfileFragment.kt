
package com.example.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_doctor_profile.view.*

class DoctorProfileFragment : Fragment() {
    private val args by navArgs<DoctorProfileFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_doctor_profile, container, false)
        view.tv_DetailName.setText(args.currentUser.name)
        view.tv_DetailAddress.setText(args.currentUser.address)
        view.tv_DetailSpeciality.setText(args.currentUser.speciality)

        view.btn_DetailAppointment.setOnClickListener {
            Toast.makeText(requireContext()," Take your appointment ", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_doctorProfileFragment_to_bookingFragment)
        }
        return view
    }
}