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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.databinding.FragmentRecipeBinding
import com.example.recipe.network.NetworkResult
import com.example.recipe.ui.RecipeSharedVM
import com.example.recipe.ui.recipelist.adapter.RecipeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RecipeFragment(val tabName: String) : Fragment() {
    lateinit var binding: FragmentRecipeBinding
    private val sharedVM: RecipeSharedVM by activityViewModels()
    private val viewModel: RecipeViewModel by viewModels()
    private lateinit var adapter: RecipeAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewModel.getRecipeList(tabName, 1)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        observeRecipes()
        adapter = RecipeAdapter(arrayListOf())
        setRecyclerView()
    }

    private fun observeRecipes() {
        viewModel.recipes.observe(viewLifecycleOwner, {
            when (it) {
                is NetworkResult.Success -> {
                    //binding.progressIndicator.visibility = View.INVISIBLE
                    sharedVM.recipes = it.data
                    it.data?.let(adapter::setData)
                    Log.d("recipes", "observeLiveData: ${it.data}")

                }
                is NetworkResult.Error -> {
                    //binding.progressIndicator.visibility = View.INVISIBLE
                    //binding.ivError.setImageResource(R.drawable.ic_baseline_error_24)
                    Toast.makeText(
                        context,
                        "An exception occured: ${sharedVM.errorMessage}",
                        Toast.LENGTH_LONG
                    ).show()
                }
                is NetworkResult.Loading -> {
                    //binding.progressIndicator.visibility = View.VISIBLE
                }
                else -> {}
            }
        })
    }

    private fun setRecyclerView() {
        binding.rvRecipes.apply {
            adapter = this@RecipeFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}