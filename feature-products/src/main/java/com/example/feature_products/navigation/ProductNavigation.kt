package com.example.feature_products.navigation

import android.view.View
import androidx.navigation.findNavController
import com.example.feature_products.R

class ProductNavigation {

    private var view: View? = null

    fun setView(view: View?) {
        this.view = view
    }

    fun navigateToProductListFragment() {
        view?.findNavController()?.navigate(R.id.action_searchFragment_to_productListFragment)
    }

    fun navigateToSearchFragment() {
        view?.findNavController()?.navigate(R.id.action_productListFragment_to_searchFragment)
    }

    fun navigateToProductDetailFragment() {
        view?.findNavController()?.navigate(R.id.action_productListFragment_to_detailFragment)
    }

}