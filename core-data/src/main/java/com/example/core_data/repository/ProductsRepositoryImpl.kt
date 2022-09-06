package com.example.core_data.repository

import com.example.core_common.result.Result
import com.example.core_data.error.Data
import com.example.core_data.error.ErrorManager
import com.example.core_data.error.ProductError
import com.example.core_data.model.ProductsResultEntity
import com.example.core_data.model.mapToEntity
import com.example.core_network.ProductsNetworkDataSource
import com.example.core_network.model.item_and_search.ItemAndSearchBaseResponse
import javax.inject.Inject

class ProductsRepositoryImpl @Inject constructor(
    private val networkDataSource: ProductsNetworkDataSource
) : ProductsRepository {

    override suspend fun getProductsBySearch(
        searchQuery: String,
        offset: String?,
        limit: String?
    ): Data<ProductsResultEntity> {
        val result = networkDataSource.getProducts(searchQuery, offset, limit)
        return when (val status = result.status) {
            is Result.Status.ERROR -> Data.Error(
                ProductError(
                    status.code.toString(),
                    status.errorBody
                )
            )
            else -> Data.Success(result.data?.mapToEntity())
        }
    }
}