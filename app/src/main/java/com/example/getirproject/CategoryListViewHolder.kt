package com.example.getirproject

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView

class CategoryListViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {


    var thumnail: SimpleDraweeView = itemView.findViewById(R.id.thumbnail)
    var title: TextView = itemView.findViewById(R.id.title)

    fun bindItems(itemModel: Category, listener: onItemClickListener) {

        thumnail.setImageURI(itemModel.thumbnail)
        title.text = itemModel.title

        itemView.setOnClickListener {

            listener.onItemClick(itemModel.title)


        }
    }

    interface onItemClickListener {
        fun onItemClick(name: String)
    }

}