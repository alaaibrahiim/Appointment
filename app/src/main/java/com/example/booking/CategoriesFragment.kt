package com.example.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.booking.databinding.FragmentCategoriesBinding

class CategoriesFragment : Fragment(), OnCategoryClick {

    lateinit var binding: FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lateinit var layoutManager: RecyclerView.LayoutManager
        val recyclerAdapter: RecyclerAdapter by lazy {
            RecyclerAdapter()
        }

        var categoryList: ArrayList<Category> = ArrayList()


        for (i in 0..3) {
            when (i % 4) {
                0 -> categoryList.add(Category("orthodontics ", R.drawable.img1))
                1 -> categoryList.add(Category("Endodontics", R.drawable.img2))
                2 -> categoryList.add(Category("Dental Public Health", R.drawable.img3))
                else -> categoryList.add(
                    Category(
                        "Oral and Maxillofacial Surgery.",
                        R.drawable.img
                    )
                )
            }
            recyclerAdapter.setList(categoryList)

        }

        layoutManager = GridLayoutManager(context, 2)
        binding.recyclerView.layoutManager = layoutManager



        binding.recyclerView.adapter = recyclerAdapter


        recyclerAdapter.onCategoryClick = this

    }

    override fun onItemCategoryClick(category: Category) {
        Toast.makeText(context, "The category name is :${category.name}", Toast.LENGTH_SHORT).show()
        var action = CategoriesFragmentDirections.actionCategoriesFragmentToDoctorsFragment()
        findNavController().navigate(action)
    }

}





