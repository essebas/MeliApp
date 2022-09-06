package com.example.core_network

import com.example.core_common.result.Result
import com.example.core_network.model.item_and_search.ItemAndSearchBaseResponse

interface ProductsNetworkDataSource {
    suspend fun getProducts(searchQuery: String, offset: String?, limit: String?): Result<ItemAndSearchBaseResponse>
}