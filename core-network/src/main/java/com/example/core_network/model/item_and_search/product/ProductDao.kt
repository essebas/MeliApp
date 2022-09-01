package com.example.core_network.model.item_and_search.product


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ProductDao(
    @SerialName("accepts_mercadopago")
    val acceptsMercadopago: Boolean,
    @SerialName("address")
    val address: AddressDao,
    @SerialName("attributes")
    val attributes: List<AttributeDao>,
    @SerialName("available_quantity")
    val availableQuantity: Int,
    @SerialName("buying_mode")
    val buyingMode: String,
    @SerialName("catalog_listing")
    val catalogListing: Boolean,
    @SerialName("catalog_product_id")
    val catalogProductId: String,
    @SerialName("category_id")
    val categoryId: String,
    @SerialName("condition")
    val condition: String,
    @SerialName("currency_id")
    val currencyId: String,
    //@SerialName("discounts")
    //val discounts: Any?,
    @SerialName("domain_id")
    val domainId: String,
    @SerialName("id")
    val id: String,
    @SerialName("installments")
    val installments: InstallmentsDao,
    @SerialName("listing_type_id")
    val listingTypeId: String,
    /*@SerialName("match_score")
    val matchScore: Any?,
    @SerialName("melicoin")
    val melicoin: Any?,
    @SerialName("offer_score")
    val offerScore: Any?,
    @SerialName("offer_share")
    val offerShare: Any?,
    @SerialName("official_store_id")
    val officialStoreId: Any?,*/
    @SerialName("order_backend")
    val orderBackend: Int,
    //@SerialName("original_price")
    //val originalPrice: Any?,
    @SerialName("permalink")
    val permalink: String,
    @SerialName("price")
    val price: Int,
    @SerialName("prices")
    val prices: PricesDao,
    //@SerialName("sale_price")
    //val salePrice: Any?,
    @SerialName("seller")
    val seller: SellerDao,
    @SerialName("seller_address")
    val sellerAddress: SellerAddressDao,
    @SerialName("shipping")
    val shipping: ShippingDao,
    @SerialName("site_id")
    val siteId: String,
    @SerialName("sold_quantity")
    val soldQuantity: Int,
    @SerialName("stop_time")
    val stopTime: String,
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("thumbnail")
    val thumbnail: String,
    @SerialName("thumbnail_id")
    val thumbnailId: String,
    @SerialName("title")
    val title: String,
    @SerialName("use_thumbnail_id")
    val useThumbnailId: Boolean,
    //@SerialName("winner_item_id")
    //val winnerItemId: Any?
)