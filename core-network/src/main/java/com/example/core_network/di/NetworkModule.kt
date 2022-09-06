package com.example.core_network.di

import com.example.core_network.BuildConfig
import com.example.core_network.ProductsNetworkDataSource
import com.example.core_network.retrofit.ProductsNetworkDataSourceImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun bindsNetworkDataSource(
        productsNetworkDataSource: ProductsNetworkDataSourceImpl
    ): ProductsNetworkDataSource

    companion object {
        @Provides
        @Singleton
        fun provideNetworkJson(): Json = Json {
            ignoreUnknownKeys = true
        }

        @Provides
        @Singleton
        fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    setLevel(HttpLoggingInterceptor.Level.BODY)
                }
            )
            .build()

        @Provides
        @Singleton
        fun provideNetworkGson(): Gson = GsonBuilder().setDateFormat("yyyy/MM/dd hh:mm:ss").create()

        @Provides
        @Singleton
        fun provideBaseUrl(): String = BuildConfig.BASE_URL

        @Provides
        @Singleton
        fun provideRetrofit(
            networkGson: Gson,
            baseUrl: String,
            okHttpClient: OkHttpClient
        ): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl + "MCO/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(networkGson))
            .build()

    }

}