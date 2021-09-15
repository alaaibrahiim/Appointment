package com.example.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booking.databinding.FragmentCategoriesBinding


class CategoriesFragment : Fragment() {
    lateinit var binding: FragmentCategoriesBinding
    lateinit  var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
    lateinit var layoutManager: RecyclerView.LayoutManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        layoutManager= GridLayoutManager(context,2)
        binding.recyclerView.layoutManager=layoutManager

        adapter=RecyclerAdapter()
        binding.recyclerView.adapter=adapter

    }
}





