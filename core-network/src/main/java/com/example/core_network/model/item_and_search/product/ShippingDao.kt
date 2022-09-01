package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShippingDao(
    @SerialName("free_shipping")
    val freeShipping: Boolean,
    @SerialName("logistic_type")
    val logisticType: String,
    @SerialName("mode")
    val mode: String,
    @SerialName("store_pick_up")
    val storePickUp: Boolean,
    @SerialName("tags")
    val tags: List<String>
)