package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SellerDao(
    @SerialName("car_dealer")
    val carDealer: Boolean,
    @SerialName("id")
    val id: Int,
    //@SerialName("permalink")
    //val permalink: AnyDao?,
    @SerialName("real_estate_agency")
    val realEstateAgency: Boolean,
    /*@SerialName("registration_date")
    val registrationDate: AnyDao?,
    @SerialName("tags")
    val tags: AnyDao?*/
)