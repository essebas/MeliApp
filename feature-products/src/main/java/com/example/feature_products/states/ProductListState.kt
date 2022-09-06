package com.example.feature_products.states

sealed class ProductListState {
    object EmptySearch : ProductListState()
    data class Loading(val isLoading: Boolean) : ProductListState()
}