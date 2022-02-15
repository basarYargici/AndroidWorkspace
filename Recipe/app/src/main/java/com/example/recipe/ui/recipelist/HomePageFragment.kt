package com.example.recipe.ui.recipelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.recipe.R
import com.example.recipe.databinding.FragmentHomepageBinding
import com.example.recipe.network.NetworkResult
import com.example.recipe.ui.RecipeSharedVM
import com.example.recipe.ui.recipelist.adapter.RecipeAdapter
import com.example.recipe.ui.recipelist.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomepageBinding
    private val viewModel: RecipeListViewModel by viewModels()
    private val sharedVM: RecipeSharedVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomepageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.sharedVM = sharedVM
        observeLiveData()

        lifecycleScope.launch {
            viewModel.getCategoryList()
            setViewPager()
        }
    }

    private fun setViewPager() {
        binding.viewPager.adapter =
            ViewPagerAdapter(
                this,
                viewModel.categories.value?.data ?: arrayListOf(),
            )
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        viewPager.offscreenPageLimit = 3
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = sharedVM.categories?.get(position)?.title
        }.attach()
    }

    private fun observeLiveData() {
        observeCategories()
    }


    private fun observeCategories() {
        viewModel.categories.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    binding.progressIndicator.visibility = View.INVISIBLE
                    sharedVM.categories = it.data
                    Log.d("categories", "observeLiveData: ${it.data}")
                }
                is NetworkResult.Error -> {
                    binding.progressIndicator.visibility = View.INVISIBLE
                    binding.ivError.setImageResource(R.drawable.ic_baseline_error_24)
                    Toast.makeText(
                        context,
                        "An exception occured: ${sharedVM.errorMessage}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is NetworkResult.Loading -> {
                    binding.progressIndicator.visibility = View.VISIBLE
                }
                else -> {}
            }
        })
    }

}