package com.example.feature_products.fragments.search

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.feature_products.ProductActivity
import com.example.feature_products.ProductViewModel
import com.example.feature_products.databinding.FragmentSearchBinding
import com.example.feature_products.navigation.ProductNavigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory

    private lateinit var navigation: ProductNavigation

    private val mainProductViewModel: ProductViewModel by activityViewModels { factory }

    private val searchViewModel: SearchViewModel by viewModels { factory }

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigation = (activity as ProductActivity).getNavigation()
        navigation.setView(view)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() {
        binding.btnSearch.setOnClickListener { searchProduct(binding.editTextTextPersonName.text.toString()) }
        binding.editTextTextPersonName.setOnEditorActionListener { textView, i, _ ->
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                searchProduct(textView.text.toString())
            }
            false
        }
    }

    private fun searchProduct(searchQuery: String) {
        mainProductViewModel.setSearchQuery(searchQuery)
        mainProductViewModel.setSearchItems(true)
        navigation.navigateToProductListFragment()
    }

}