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
        viewModel.getRecipeList("chicken", 1)
        observeLiveData()
    }

    private fun setViewPager() {
        binding.viewPager.adapter = ViewPagerAdapter(this, 2, sharedVM.recipes)
        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
    }

    private fun observeLiveData() {
        viewModel.recipes.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    binding.progressIndicator.visibility = View.INVISIBLE
                    sharedVM.recipes = it.data
                    Log.d("TAG", "observeLiveData: ${it.data}")
                    adapter = RecipeAdapter(sharedVM.recipes)
                    setViewPager()
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