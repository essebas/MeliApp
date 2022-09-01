package com.example.core_network

import com.example.core_network.model.item_and_search.ItemAndSearchBaseResponse
import retrofit2.Response

interface ProductsNetworkDataSource {
    suspend fun getProducts(searchQuery: String): Response<ItemAndSearchBaseResponse>
}