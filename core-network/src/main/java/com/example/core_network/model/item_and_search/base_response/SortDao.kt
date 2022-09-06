package com.example.core_network.model.item_and_search.base_response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SortDao(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String
)