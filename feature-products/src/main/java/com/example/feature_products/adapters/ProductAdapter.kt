package com.example.feature_products.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.core_data.model.ProductEntity
import com.example.feature_products.R
import com.example.feature_products.adapters.diff_util.ProductDiffUtil
import com.example.feature_products.databinding.ProductItemBinding

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private var productList = emptyList<ProductEntity>()
    private var onItemClickListener: ((ProductEntity) -> Unit)? = null

    inner class ProductViewHolder(val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.binding.imgProduct.run {
            Glide.with(context)
                .setDefaultRequestOptions(RequestOptions().placeholder(R.drawable.product_image))
                .load(product.imageUrl)
                .into(this)
        }
        holder.binding.txvTitle.text = product.title
        holder.binding.txvPrice.text = product.price.toString()
        holder.binding.productCardView.setOnClickListener {
            onItemClickListener?.let { it(product) }
        }
    }

    override fun getItemCount() = productList.size

    fun setData(newProductList: List<ProductEntity>) {
        val diffUtil = ProductDiffUtil(productList, newProductList)
        val diffResult = DiffUtil.calculateDiff(diffUtil)
        productList = newProductList
        diffResult.dispatchUpdatesTo(this)
    }

    fun setOnItemClickListener(listener: (ProductEntity) -> Unit) {
        onItemClickListener = listener
    }
}