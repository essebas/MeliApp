package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PricesDao(
    @SerialName("id")
    val id: String,
    //@SerialName("payment_method_prices")
    //val paymentMethodPrices: List<Any>,
    @SerialName("presentation")
    val presentation: PresentationDao,
    @SerialName("prices")
    val prices: List<PriceDao>,
    //@SerialName("purchase_discounts")
    //val purchaseDiscounts: List<Any>,
    @SerialName("reference_prices")
    val referencePrices: List<ReferencePriceDao>
)