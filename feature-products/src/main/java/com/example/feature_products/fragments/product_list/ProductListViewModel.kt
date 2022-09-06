package com.example.feature_products.fragments.product_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core_common.network.AppActions
import com.example.core_common.network.AppDispatchers
import com.example.core_common.network.Dispatcher
import com.example.core_common.result.Result
import com.example.core_common.ui.BaseViewModel
import com.example.core_common.utils.StringUtil
import com.example.core_data.error.Data
import com.example.core_data.model.ProductEntity
import com.example.core_data.model.ProductsResultEntity
import com.example.core_data.repository.ProductsRepository
import com.example.feature_products.states.ProductListState
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

const val INITIAL_OFFSET_TO_SEARCH = 0
const val OFFSET_TO_INCREMENT = 50

class ProductListViewModel @Inject constructor(
    private val repository: ProductsRepository
) : BaseViewModel() {

    private val _currentOffset = MutableLiveData(INITIAL_OFFSET_TO_SEARCH)
    private val currentOffset: String get() = _currentOffset.value.toString()

    private val _queryResults = MutableLiveData(StringUtil.EMPTY_STRING)
    val queryResults: LiveData<String> get() = _queryResults

    private val _products = MutableLiveData(listOf<ProductEntity>())
    val products: LiveData<List<ProductEntity>> get() = _products

    private val _currentQuery = MutableLiveData(StringUtil.EMPTY_STRING)
    private val currentQuery: String get() = _currentQuery.value ?: StringUtil.EMPTY_STRING

    private val _state = MutableLiveData<ProductListState>()
    val state: LiveData<ProductListState> get() = _state


    fun getProducts() = executeBlockOnBackground {
        setState(ProductListState.Loading(true))
        when (val response = repository.getProductsBySearch(currentQuery, currentOffset)) {
            is Data.Success -> processProducts(response.data)
            else -> handleError()
        }
        setState(ProductListState.Loading(false))
    }

    fun setQuery(querySearch: String) {
        _currentQuery.value = querySearch
    }

    private fun processProducts(productsResult: ProductsResultEntity?) {
        productsResult?.let {
            if (productsResult.products.isEmpty() && _products.value.isNullOrEmpty()) {
                setState(ProductListState.EmptySearch)
            } else {
                _queryResults.postValue(it.paging.total)
                _currentOffset.postValue(_currentOffset.value?.plus(OFFSET_TO_INCREMENT))
                _products.postValue(_products.value?.plus(productsResult.products))
            }
        }
    }

    private fun setState(state: ProductListState) = executeBlockOnMain {
        _state.value = state
    }

    private fun handleError() {

    }
}