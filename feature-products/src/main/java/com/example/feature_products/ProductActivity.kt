package com.example.feature_products

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.feature_products.navigation.ProductNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private val productViewModel: ProductViewModel by viewModels { factory }

    private val productNavigation = ProductNavigation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)
    }

    fun getNavigation() = productNavigation

    companion object {
        fun newInstance(context: Context): Intent = Intent(context, ProductActivity::class.java)
    }

}