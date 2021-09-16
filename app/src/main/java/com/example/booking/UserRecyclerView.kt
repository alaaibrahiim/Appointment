package com.example.booking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserRecyclerView :
    RecyclerView.Adapter<UserRecyclerView.UserViewHolder>() {

    var userList:ArrayList<User> = ArrayList()

    fun setList(userList:ArrayList<User>){
        this.userList=userList
        notifyDataSetChanged()
    }

    var onListItemClick: onListItemClick? = null

    inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var tv_userName: TextView = itemView.findViewById(R.id.tv_item_username)
        var tv_userAddress: TextView = itemView.findViewById(R.id.tv_item_address)
        var iv_userImage: ImageView = itemView.findViewById(R.id.iv_item_userimage)

        fun bind(user: User) {
            tv_userName.text = user.name
            tv_userAddress.text = user.addrss
            iv_userImage.setImageResource(user.iamgeId)

            itemView.setOnClickListener {
                onListItemClick?.onItemClick(user)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.bind(user)

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}