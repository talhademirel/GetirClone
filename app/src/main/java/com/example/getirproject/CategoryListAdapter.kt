package com.example.getirproject


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CategoryListAdapter(
    var categoryList: ArrayList<Category>,
    var clickListner: CategoryListViewHolder.onItemClickListener
) :
    RecyclerView.Adapter<CategoryListViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryListViewHolder {
        val itemHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)
        return CategoryListViewHolder(itemHolder)
    }

    override fun onBindViewHolder(holder: CategoryListViewHolder, position: Int) {
        holder.bindItems(categoryList[position], clickListner)

    }

    override fun getItemCount(): Int {
        return categoryList.size
    }


}