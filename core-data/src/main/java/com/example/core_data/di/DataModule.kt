package com.example.core_data.di

import com.example.core_data.repository.ProductsRepository
import com.example.core_data.repository.ProductsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindProductRepository(
        repository: ProductsRepositoryImpl
    ): ProductsRepository
}