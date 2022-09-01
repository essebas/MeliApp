package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerAddressDao(
    @SerialName("address_line")
    val addressLine: String,
    @SerialName("city")
    val city: CityDao,
    @SerialName("comment")
    val comment: String,
    @SerialName("country")
    val country: CountryDao,
    @SerialName("id")
    val id: String,
    @SerialName("latitude")
    val latitude: String,
    @SerialName("longitude")
    val longitude: String,
    @SerialName("state")
    val state: StateDao,
    @SerialName("zip_code")
    val zipCode: String
)