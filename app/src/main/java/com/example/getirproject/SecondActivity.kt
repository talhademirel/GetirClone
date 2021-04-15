package com.example.getirproject

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class SecondActivity : AppCompatActivity(), ProductsListViewHolder.onItemClickListener {

    lateinit var productsRecyclerView: RecyclerView
    lateinit var list: ArrayList<Products>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.products_list)

        productsRecyclerView = findViewById(R.id.productsRecyclerView)
        productsRecyclerView.layoutManager = GridLayoutManager(this, 3)
        list = ArrayList()
        setDataInList()


    }

    fun setDataInList() {

        title = intent.getStringExtra("title")

        if (title == "Meyve & Sebze") {

            val db = Firebase.firestore

            db.collection("/Category/1/Products")
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        Log.d("TAG1", "${document.id} => ${document.get("name")}")
                        val uri = Uri.parse(document.get("imageUrl").toString())
                        list.add(
                            Products(
                                document.get("name").toString(),
                                uri,
                                document.get("price").toString(),
                                document.get("weight").toString(),
                                document.get("details").toString()
                            )
                        )
                        productsRecyclerView.adapter = ProductsListAdapter(list, this)
                    }
                }

                .addOnFailureListener { exception ->
                    Log.d("TAG", "Error getting documents: ", exception)
                }

        }

    }

    override fun onItemClick(
        thumbnail: Uri,
        name: String,
        price: String,
        weight: String,
        details: String
    ) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra("thumbnail", thumbnail.toString())
        intent.putExtra("name", name)
        intent.putExtra("price", price)
        intent.putExtra("weight", weight)
        intent.putExtra("details", details)
        startActivity(intent)
    }
}