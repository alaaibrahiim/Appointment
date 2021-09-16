package com.example.booking

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.UserViewHolder>() {

    var onCategoryClick:OnCategoryClick?=null
    var categoryList:ArrayList<Category> = ArrayList()

    fun setList(categoryList:ArrayList<Category>){
        this.categoryList=categoryList
        notifyDataSetChanged()
    }

    inner class UserViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        var iv_img:ImageView=itemView.findViewById(R.id.imageView)
        var tv_categoryname:TextView=itemView.findViewById(R.id.textView)


        fun bind(category: Category){
            iv_img.setImageResource(category.img)
            tv_categoryname.text=category.name

            itemView.setOnClickListener {
                onCategoryClick?.onItemCategoryClick(category)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view:View =LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoryList.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        var category:Category=categoryList.get(position)
        holder.bind(category)
    }

}
