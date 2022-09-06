package com.example.core_data.model

import com.example.core_common.utils.StringUtil
import com.example.core_network.model.item_and_search.product.ProductDao

data class ProductEntity(
    val id: String,
    val imageUrl: String,
    val title: String,
    val price: String,
    val availableQuantity: Int,
    val condition: String,
    val attributes: List<ProductAttrsEntity>
)

fun List<ProductDao>.mapToListEntity() = map { it.mapToEntity() }

fun ProductDao.mapToEntity() = ProductEntity(
    id = id,
    imageUrl = thumbnail,
    title = title,
    price = StringUtil.getMoneyFormat(price),
    availableQuantity = availableQuantity,
    condition = condition,
    attributes = attributes.mapToListEntity()
)
