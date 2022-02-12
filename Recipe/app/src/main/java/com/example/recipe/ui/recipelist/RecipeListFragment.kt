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
import com.example.recipe.R
import com.example.recipe.databinding.FragmentRecipeListBinding
import com.example.recipe.network.NetworkResult
import com.example.recipe.ui.RecipeSharedVM
import com.example.recipe.ui.recipelist.adapter.RecipeAdapter
import com.example.recipe.ui.recipelist.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {
    private lateinit var binding: FragmentRecipeListBinding
    private val viewModel: RecipeListViewModel by viewModels()
    private val sharedVM: RecipeSharedVM by activityViewModels()
    private lateinit var adapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.sharedVM = sharedVM
        observeLiveData()

        getApiReq(1)
    }

    fun getApiReq(page: Int) {
        viewModel.launch {
            viewModel.getCategoryList()
            viewModel.getRecipeList(sharedVM.categories?.get(0)?.title.toString(), page)
            setViewPager()
        }
    }

    private fun setViewPager() {
        binding.viewPager.adapter =
            ViewPagerAdapter(
                this, viewModel.categories.value?.data?.size ?: 0, viewModel.recipes.value?.data ?: listOf
                    (), adapter
            )
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = sharedVM.categories?.get(position)?.title
        }.attach()

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                binding.viewPager.adapter =
                    ViewPagerAdapter(
                        this@RecipeListFragment, 0, listOf(), adapter
                    )
                viewModel.launch {
                    Toast.makeText(context, "onTabSelected", Toast.LENGTH_SHORT).show()
                    viewModel.getRecipeList(tab?.text.toString(), 1)
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(context, "onTabUnselected", Toast.LENGTH_SHORT).show()

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(context, "onTabReselected", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun observeLiveData() {
        observeRecipes()
        observeCategories()
    }

    // TODO: 12.02.2022 problem: calls the setViewPager and refreshes tab to position 0. use
    //  tabLayout.addOnTabSelectedListener()
    private fun observeRecipes() {
        viewModel.recipes.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    binding.progressIndicator.visibility = View.INVISIBLE
                    sharedVM.recipes = it.data
                    Log.d("recipes", "observeLiveData: ${it.data}")
                    adapter = RecipeAdapter(sharedVM.recipes)

                    binding.viewPager.adapter =
                        ViewPagerAdapter(
                            this,
                            viewModel.categories.value?.data?.size ?: 0,
                            viewModel.recipes.value?.data ?: listOf(),
                            adapter
                        )
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