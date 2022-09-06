package com.example.core_data.model

import com.example.core_common.utils.StringUtil
import com.example.core_network.model.item_and_search.base_response.PagingDao

data class PagingEntity(
    val total: String,
    val primaryResults: Int,
    val offset: Int,
    val limit: Int
)

fun PagingDao.mapToEntity() = PagingEntity(
    StringUtil.getNumberDecimalFormat(total), primaryResults, offset, limit
)
