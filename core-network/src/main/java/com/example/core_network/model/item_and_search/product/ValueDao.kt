package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ValueDao(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("source")
    val source: Int,
    @SerialName("struct")
    val struct: StructDao?
)