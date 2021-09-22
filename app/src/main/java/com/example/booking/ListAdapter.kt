package com.example.booking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.custom_room.view.*


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList= emptyList<User>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_room,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = userList[position]
        holder.itemView.tv_item_username .text = currentItem.name
        holder.itemView.tv_item_address.text = currentItem.address
        holder.itemView.tv_item_speciality.text = currentItem.speciality

        holder.itemView.roomLayout.setOnClickListener{
            val action = DoctorsFragmentDirections.actionDoctorsFragmentToDoctorProfileFragment(currentItem)
            holder.itemView.findNavController().navigate(action)

        }

    }
    fun setData(user: List<User>){
        this.userList = user
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}