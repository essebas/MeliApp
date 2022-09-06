package com.example.feature_products.fragments.product_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.core_data.model.ProductEntity
import com.example.feature_products.ProductActivity
import com.example.feature_products.ProductViewModel
import com.example.feature_products.R
import com.example.feature_products.databinding.FragmentDetailBinding
import com.example.feature_products.navigation.ProductNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var navigation: ProductNavigation

    private val mainProductViewModel: ProductViewModel by activityViewModels { factory }

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation = (activity as ProductActivity).getNavigation()
        navigation.setView(view)
        initView()
        setObservers()
    }

    private fun initView() {
        mainProductViewModel.setSearchItems(false)
    }

    private fun setObservers() {
        mainProductViewModel.productSelected.observe(viewLifecycleOwner, ::showProductDetails)
    }

    private fun showProductDetails(product: ProductEntity) {
        binding.apply {
            imgProduct.run {
                Glide.with(context)
                    .setDefaultRequestOptions(RequestOptions().placeholder(R.drawable.product_image))
                    .load(product.imageUrl)
                    .into(this)
            }
            txvTitle.text = product.title
            txvPrice.text = product.price
            txvCondition.text = product.condition
        }
    }
}