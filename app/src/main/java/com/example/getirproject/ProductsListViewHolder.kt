package com.example.getirproject

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.view.SimpleDraweeView

class ProductsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    var thumbnail: SimpleDraweeView = itemView.findViewById(R.id.ProductThumbnail)
    var name: TextView = itemView.findViewById(R.id.ProductName)
    var price: TextView = itemView.findViewById(R.id.ProductPrice)
    var weight: TextView = itemView.findViewById(R.id.ProductWeight)


    fun bindItems(itemModel: Products, listener: onItemClickListener) {

        thumbnail.setImageURI(itemModel.thumbnail)
        name.text = itemModel.name
        price.text = itemModel.price
        weight.text = itemModel.weight

        itemView.setOnClickListener {

            listener.onItemClick(
                itemModel.thumbnail,
                itemModel.name,
                itemModel.price,
                itemModel.weight,
                itemModel.details
            )


        }

    }

    interface onItemClickListener {
        fun onItemClick(
            thumbnail: Uri,
            name: String,
            price: String,
            weight: String,
            details: String
        )
    }


}