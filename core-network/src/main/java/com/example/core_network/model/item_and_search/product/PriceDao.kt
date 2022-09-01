package com.example.core_network.model.item_and_search.product

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PriceDao(
    @SerialName("amount")
    val amount: Int,
    @SerialName("conditions")
    val conditions: ConditionsDao,
    @SerialName("currency_id")
    val currencyId: String,
    @SerialName("exchange_rate_context")
    val exchangeRateContext: String,
    @SerialName("id")
    val id: String,
    @SerialName("last_updated")
    val lastUpdated: String,
    @SerialName("metadata")
    val metadata: MetadataDao?,
    //@SerialName("regular_amount")
    //val regularAmount: AnyDao?,
    @SerialName("type")
    val type: String
)