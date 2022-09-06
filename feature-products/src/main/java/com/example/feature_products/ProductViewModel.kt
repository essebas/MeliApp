package com.example.feature_products

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.core_common.ui.BaseViewModel
import com.example.core_common.utils.StringUtil
import com.example.core_data.model.ProductEntity
import javax.inject.Inject

class ProductViewModel @Inject constructor() : BaseViewModel() {

    private val _searchQuery = MutableLiveData(StringUtil.EMPTY_STRING)
    val searchQuery: LiveData<String> get() = _searchQuery

    private val _productSelected = MutableLiveData<ProductEntity>()
    val productSelected: LiveData<ProductEntity> get() = _productSelected

    private val _searchItems = MutableLiveData<Boolean>(false)
    val searchItems: LiveData<Boolean> get() = _searchItems

    fun setSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun setProductSelected(product: ProductEntity) {
        _productSelected.value = product
    }

    fun setSearchItems(isNecessarySearchItems: Boolean) {
        _searchItems.value = isNecessarySearchItems
    }
}