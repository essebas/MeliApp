package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InstallmentsDao(
    @SerialName("amount")
    val amount: Double,
    @SerialName("currency_id")
    val currencyId: String,
    @SerialName("quantity")
    val quantity: Int,
    @SerialName("rate")
    val rate: Int
)