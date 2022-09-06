package com.example.core_data.model

import com.example.core_network.model.item_and_search.ItemAndSearchBaseResponse

data class ProductsResultEntity(
    val products: List<ProductEntity>,
    val paging: PagingEntity
)

fun ItemAndSearchBaseResponse.mapToEntity() = ProductsResultEntity(
    products = results.mapToListEntity(),
    paging = paging.mapToEntity()
)
