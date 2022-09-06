package com.example.meliapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.feature_products.ProductActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startActivity(ProductActivity.newInstance(this@MainActivity))
    }
}