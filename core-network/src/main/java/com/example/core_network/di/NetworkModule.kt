package com.example.core_network.di

import com.example.core_network.ProductsNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import kotlinx.serialization.json.Json

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {

    @Binds
    fun bindsNetworkDataSource(): ProductsNetworkDataSource

    companion object {
        @Provides
        @Singleton
        fun provideNetworkJson(): Json = Json {
            ignoreUnknownKeys = true
        }
    }

}