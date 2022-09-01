package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StructDao(
    @SerialName("number")
    val number: Int,
    @SerialName("unit")
    val unit: String
)