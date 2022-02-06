package com.example.recipe.ui.recipelist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.databinding.FragmentRecipeViewPageBinding
import com.example.recipe.ui.RecipeSharedVM
import com.example.recipe.ui.recipelist.adapter.RecipeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeViewPageFragment(
    var adapter: RecipeAdapter
) : Fragment() {
    lateinit var binding: FragmentRecipeViewPageBinding
    private val sharedVM: RecipeSharedVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeViewPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // TODO ask?
        Log.d("asd", "asdasd: ${sharedVM.recipes}")
        Log.d("asd", "asdasd: ${adapter.itemCount}")
        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.rvRecipes.apply {
            adapter = this@RecipeViewPageFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}