package com.example.getirproject

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class HomeFragment : Fragment(R.layout.category_list), CategoryListViewHolder.onItemClickListener {

    lateinit var categoryListRecyclerView: RecyclerView
    lateinit var list: ArrayList<Category>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryListRecyclerView = view.findViewById(R.id.category_recyclerView)
        categoryListRecyclerView.layoutManager = GridLayoutManager(activity, 4)
        list = ArrayList()
        setDataInList()

    }


    fun setDataInList() {

        val db = Firebase.firestore

        db.collection("Category")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d("TAG1", "${document.id} => ${document.get("name")}")
                    val uri = Uri.parse(document.get("imageUrl").toString())
                    list.add(Category(document.get("name").toString(), uri))
                    categoryListRecyclerView.adapter = CategoryListAdapter(list, this)
                }
            }
            .addOnFailureListener { exception ->
                Log.d("TAG", "Error getting documents: ", exception)
            }


    }


    override fun onItemClick(name: String) {
        val intent = Intent(activity, SecondActivity::class.java)
        intent.putExtra("title", name)
        startActivity(intent)
    }


}