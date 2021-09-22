package com.example.booking

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_doctors.view.*


class DoctorsFragment: Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_doctors,container,false)
        // for recyclerview
        val adapter = ListAdapter()
        val recyclerView = view.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //for Userviewmodel
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)
        })
        view.floatingActionButton.setOnClickListener{
            findNavController().navigate(R.id.action_doctorsFragment_to_addDoctorFragment)
        }

        view.btn_logout.setOnClickListener {
            val eBuilder = AlertDialog.Builder(context)
            eBuilder.setTitle("EXIT!")
            eBuilder.setIcon(R.drawable.ic_exit)
            eBuilder.setMessage("Are you sure you want to EXIT?")
            eBuilder.setPositiveButton("Yes") { Dialog, which ->
                activity?.finish()

            }
            eBuilder.setPositiveButton("No") { Dialog, which ->
                Toast.makeText(context, "Press again to exit app", Toast.LENGTH_SHORT).show()
            }
            val createBuild: AlertDialog = eBuilder.create()
            createBuild.show()
        }
        return view


    }


}



