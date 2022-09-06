package com.example.feature_products.di

import androidx.lifecycle.ViewModel
import com.example.core_common.ui.ViewModelKey
import com.example.feature_products.ProductViewModel
import com.example.feature_products.fragments.product_list.ProductListViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap

@Module
@InstallIn(SingletonComponent::class)
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ProductListViewModel::class)
    internal abstract fun bindProductListViewModel(
        viewModel: ProductListViewModel
    ): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(ProductViewModel::class)
    internal abstract fun binProductViewModel(
        viewModel: ProductViewModel
    ): ViewModel
}