package com.example.getirproject

import android.net.Uri

data class Products(
    var name: String,
    var thumbnail: Uri,
    var price: String,
    var weight: String,
    var details: String
)
