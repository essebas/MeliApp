package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AddressDao(
    @SerialName("city_id")
    val cityId: String,
    @SerialName("city_name")
    val cityName: String,
    @SerialName("state_id")
    val stateId: String,
    @SerialName("state_name")
    val stateName: String
)