package com.example.getirproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ProductsListAdapter(
    var productsList: ArrayList<Products>,
    var listener: ProductsListViewHolder.onItemClickListener
) :
    RecyclerView.Adapter<ProductsListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsListViewHolder {
        val itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.products_list_item, parent, false)
        return ProductsListViewHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: ProductsListViewHolder, position: Int) {
        holder.bindItems(productsList[position], listener)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }


}