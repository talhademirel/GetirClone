package com.example.getirproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.facebook.drawee.view.SimpleDraweeView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_detail)

        val thumbnail = intent.getStringExtra("thumbnail")
        val name = intent.getStringExtra("name")
        val price = intent.getStringExtra("price")
        val weight = intent.getStringExtra("weight")
        val details = intent.getStringExtra("details")

        val ProductdThumbnail = findViewById<SimpleDraweeView>(R.id.ProductdThumbnail)
        val ProductdName = findViewById<TextView>(R.id.ProductdName)
        val ProductdPrice = findViewById<TextView>(R.id.ProductdPrice)
        val ProductdWeight = findViewById<TextView>(R.id.ProductdWeight)
        val ProductDetail = findViewById<TextView>(R.id.ProductDetail)

        println(details)


        ProductdThumbnail.setImageURI(thumbnail)
        ProductdName.text = name
        ProductdPrice.text = price
        ProductdWeight.text = weight
        ProductDetail.text = details




    }
}