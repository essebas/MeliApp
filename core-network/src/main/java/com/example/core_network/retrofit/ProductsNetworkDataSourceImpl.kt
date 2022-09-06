package com.example.core_network.retrofit

import com.example.core_common.result.Result
import com.example.core_network.ProductsNetworkDataSource
import com.example.core_network.model.item_and_search.ItemAndSearchBaseResponse
import com.example.core_network.result.BaseNetwork
import com.google.gson.Gson
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url


interface ItemAndSearchApi {

    @GET("search")
    suspend fun getItemsBySearchQuery(
        @Query("q") searchQuery: String,
        @Query("offset") offset: String?,
        @Query("limit") limit: String?
    ): Response<ItemAndSearchBaseResponse>
}

@Singleton
class ProductsNetworkDataSourceImpl @Inject constructor(
    networkGson: Gson,
    baseUrl: String,
    okHttpClient: OkHttpClient
) : ProductsNetworkDataSource, BaseNetwork() {

    private val networkApi = Retrofit.Builder()
        .baseUrl(baseUrl + "MCO/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(networkGson))
        .build()
        .create(ItemAndSearchApi::class.java)

    override suspend fun getProducts(
        searchQuery: String,
        offset: String?,
        limit: String?
    ): Result<ItemAndSearchBaseResponse> =
        getResult {
            networkApi.getItemsBySearchQuery(searchQuery, offset, limit)
        }

}