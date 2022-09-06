package com.example.core_data.repository

import com.example.core_data.error.Data
import com.example.core_data.model.ProductsResultEntity

interface ProductsRepository {
    suspend fun getProductsBySearch(
        searchQuery: String,
        offset: String? = null,
        limit: String? = null
    ): Data<ProductsResultEntity>
}