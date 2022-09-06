package com.example.feature_products.adapters.diff_util

import androidx.recyclerview.widget.DiffUtil
import com.example.core_data.model.ProductEntity

class ProductDiffUtil(
    private val oldList: List<ProductEntity>,
    private val newList: List<ProductEntity>
) : DiffUtil.Callback() {

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[oldItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return when {
            oldList[oldItemPosition].id != newList[newItemPosition].id -> false
            oldList[oldItemPosition].title != newList[newItemPosition].title -> false
            oldList[oldItemPosition].price != newList[newItemPosition].price -> false
            else -> true
        }
    }
}