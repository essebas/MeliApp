package com.example.core_network.retrofit

import com.example.core_network.ProductsNetworkDataSource
import com.example.core_network.model.item_and_search.ItemAndSearchBaseResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Query


private interface ItemAndSearchApi {

    @GET("search")
    suspend fun getItemsBySearchQuery(
        @Query("q") searchQuery: String
    ): Response<ItemAndSearchBaseResponse>
}

@Singleton
class ProductsNetworkDataSourceImpl @Inject constructor(
    networkJson: Json
) : ProductsNetworkDataSource {

    private val networkApi = Retrofit.Builder()
        .baseUrl("https://api.mercadolibre.com/sites/MCO/")
        .client(
            OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        setLevel(HttpLoggingInterceptor.Level.BODY)
                    }
                )
                .build()
        )
        .addConverterFactory(networkJson.asConverterFactory("application/json".toMediaType()))
        .build()
        .create(ItemAndSearchApi::class.java)

    override suspend fun getProducts(searchQuery: String): Response<ItemAndSearchBaseResponse> =
        networkApi.getItemsBySearchQuery(searchQuery)

}