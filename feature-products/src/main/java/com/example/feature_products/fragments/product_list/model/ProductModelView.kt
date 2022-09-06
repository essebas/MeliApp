package com.example.feature_products.fragments.product_list.model

data class ProductModelView(
    val imageUrl: String,
    val title: String,
    val price: String,
    val availableQuantity: Int,
    val condition: String,
)
