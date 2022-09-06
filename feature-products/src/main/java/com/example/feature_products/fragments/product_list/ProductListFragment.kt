package com.example.feature_products.fragments.product_list

import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.core_data.model.ProductEntity
import com.example.feature_products.ProductActivity
import com.example.feature_products.ProductViewModel
import com.example.feature_products.R
import com.example.feature_products.adapters.ProductAdapter
import com.example.feature_products.databinding.FragmentProductListBinding
import com.example.feature_products.navigation.ProductNavigation
import com.example.feature_products.states.ProductListState
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ProductListFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var navigation: ProductNavigation

    private val mainProductViewModel: ProductViewModel by activityViewModels { factory }

    private val productsListViewModel: ProductListViewModel by viewModels { factory }

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { ProductAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation = (activity as ProductActivity).getNavigation()
        navigation.setView(view)
        initView()
        setObservers()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() {
        adapter.setOnItemClickListener(::showProductDetail)
        binding.btnSearch.setOnClickListener { navigation.navigateToSearchFragment() }
        binding.recyclerProductList.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = this@ProductListFragment.adapter
            addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (!recyclerView.canScrollVertically(1)) {
                        productsListViewModel.getProducts()
                    }
                }
            })
        }
    }

    private fun setObservers() {
        mainProductViewModel.searchQuery.observe(
            viewLifecycleOwner,
            productsListViewModel::setQuery
        )
        productsListViewModel.products.observe(viewLifecycleOwner, ::showProducts)
        productsListViewModel.queryResults.observe(viewLifecycleOwner) { total ->
            binding.txvTotalResults.text = getString(R.string.txv_query_results, total)
        }
        productsListViewModel.state.observe(viewLifecycleOwner, ::handleState)
        mainProductViewModel.searchItems.observe(viewLifecycleOwner) { isNecessarySearchItems -> if (isNecessarySearchItems) productsListViewModel.getProducts() }
    }

    private fun handleState(state: ProductListState) {
        when (state) {
            is ProductListState.Loading -> showProgressBar(state.isLoading)
            is ProductListState.EmptySearch -> showEmptySearch()
        }
    }

    private fun showProgressBar(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showEmptySearch() {
        binding.recyclerProductList.visibility = View.GONE
        binding.txvHelp.apply {
            visibility = View.VISIBLE
            text = getString(R.string.txv_empty_search_message)
        }
    }

    private fun showProducts(products: List<ProductEntity>) {
        adapter.setData(products)
    }

    private fun showProductDetail(product: ProductEntity) {
        mainProductViewModel.setProductSelected(product)
        navigation.navigateToProductDetailFragment()
    }
}