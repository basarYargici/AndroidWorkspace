package com.example.recipe.ui.recipelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.recipe.databinding.FragmentRecipeListBinding
import com.example.recipe.domain.model.Recipe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {
    lateinit var binding: FragmentRecipeListBinding
    val viewModel: RecipeListViewModel by viewModels()
    var recipes: List<Recipe>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvRecipeList.setOnClickListener {
            findNavController().navigate(RecipeListFragmentDirections.toRecipeFragment())
        }

        viewModel.getRecipeList("chicken", 1)
        binding.tvRecipeList.text = viewModel.recipes.value?.get(0)?.imageUrl ?: "Gelmedi"
        observeLiveData()
    }

    private fun observeLiveData() {
        viewModel.recipes.observe(viewLifecycleOwner, {
            recipes = it
            Log.d("test", "observeLiveData: " + it.toString())
        })
    }
}