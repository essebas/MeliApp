package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PresentationDao(
    @SerialName("display_currency")
    val displayCurrency: String
)