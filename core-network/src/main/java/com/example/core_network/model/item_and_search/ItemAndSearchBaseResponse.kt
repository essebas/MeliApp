package com.example.core_network.model.item_and_search


import com.example.core_network.model.item_and_search.base_response.AvailableFilterDao
import com.example.core_network.model.item_and_search.base_response.AvailableSortDao
import com.example.core_network.model.item_and_search.base_response.PagingDao
import com.example.core_network.model.item_and_search.base_response.SortDao
import com.example.core_network.model.item_and_search.product.ProductDao
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ItemAndSearchBaseResponse(
    @SerialName("available_filters")
    val availableFilters: List<AvailableFilterDao>,
    @SerialName("available_sorts")
    val availableSorts: List<AvailableSortDao>,
    @SerialName("country_default_time_zone")
    val countryDefaultTimeZone: String,
    /*@SerialName("filters")
    val filters: List<AnyDao>,*/
    @SerialName("paging")
    val paging: PagingDao,
    @SerialName("query")
    val query: String,
    @SerialName("results")
    val results: List<ProductDao>,
    @SerialName("site_id")
    val siteId: String,
    @SerialName("sort")
    val sort: SortDao
)