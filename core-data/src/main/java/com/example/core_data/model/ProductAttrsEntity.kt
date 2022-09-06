package com.example.core_data.model

import com.example.core_network.model.item_and_search.product.AttributeDao

data class ProductAttrsEntity(
    val title: String,
    val value: String?
)

fun List<AttributeDao>.mapToListEntity() = map { it.mapToEntity() }

fun AttributeDao.mapToEntity() = ProductAttrsEntity(
    title = name,
    value = valueName
)
