package com.example.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.booking.databinding.FragmentDoctorsBinding


class DoctorsFragment: Fragment(), onListItemClick {
    //var data = ArrayList<User>()
    val userRecyclerView: UserRecyclerView by lazy {
        UserRecyclerView()
    }
    var userList: ArrayList<User> = ArrayList()
    lateinit var binding: FragmentDoctorsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDoctorsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvShowData.layoutManager = LinearLayoutManager(context)

        for (i in 0..10) {
            userList.add(User("DoctorName" + i, "Address " + i, R.drawable.doctor3))
            userRecyclerView.setList(userList)
        }
        binding.rvShowData.adapter = userRecyclerView


        userRecyclerView.onListItemClick = this

        //  rv_showData = findViewById(R.id.rv_showData)
    }

    override fun onItemClick(user: User) {
        Toast.makeText(context, "more about  ${user.name}", Toast.LENGTH_LONG).show()
        var action = DoctorsFragmentDirections.actionDoctorsFragmentToDoctorProfileFragment()
        findNavController().navigate(action)
    }
}

