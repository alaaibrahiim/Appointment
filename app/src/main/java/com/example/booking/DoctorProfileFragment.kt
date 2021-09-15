package com.example.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.booking.databinding.FragmentDocotrProfileBinding

class DoctorProfileFragment : Fragment() {
    lateinit var binding: FragmentDocotrProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentDocotrProfileBinding.inflate(inflater, container, false)
        return binding.root
         }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnNextbooking.setOnClickListener {
            Toast.makeText(context, "Now ,You can book", Toast.LENGTH_LONG).show()

            var action=DoctorProfileFragmentDirections.actionDoctorProfileFragmentToBookingFragment()
            findNavController().navigate(action)
        }
    }
}