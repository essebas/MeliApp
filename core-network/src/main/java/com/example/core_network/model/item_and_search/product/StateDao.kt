package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StateDao(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String
)