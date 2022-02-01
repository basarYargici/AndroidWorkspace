package com.example.recipe.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipe.databinding.FragmentRecipeViewPageBinding
import com.example.recipe.domain.model.Recipe
import com.example.recipe.ui.RecipeSharedVM
import com.example.recipe.ui.recipelist.adapter.RecipeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeViewPageFragment : Fragment() {
    lateinit var binding: FragmentRecipeViewPageBinding
    val sharedVM: RecipeSharedVM by viewModels()
    private val adapter = RecipeAdapter(
        listOf(
            Recipe("1", "Source Url 1", "Img Url 1", "Publisher 1", null, "Title 1", null, "Published ID 1"),
            Recipe("2", "Source Url 2", "Img Url 2", "Publisher 2", null, "Title 2", null, "Published ID 2"),
            Recipe("3", "Source Url 3", "Img Url 3", "Publisher 3", null, "Title 3", null, "Published ID 3")
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecipeViewPageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setRecyclerView()
    }

    private fun setRecyclerView() {
        binding.rvRecipes.apply {
            adapter = this@RecipeViewPageFragment.adapter
            layoutManager = LinearLayoutManager(context)
        }
    }
}