package com.example.core_network.model.item_and_search.base_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PagingDao(
    @SerialName("limit")
    val limit: Int,
    @SerialName("offset")
    val offset: Int,
    @SerialName("primary_results")
    val primaryResults: Int,
    @SerialName("total")
    val total: Int
)