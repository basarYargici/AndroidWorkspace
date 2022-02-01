package com.example.recipe.ui.recipelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.recipe.databinding.FragmentRecipeListBinding
import com.example.recipe.domain.model.Recipe
import com.example.recipe.ui.RecipeSharedVM
import com.example.recipe.ui.recipelist.adapter.RecipeAdapter
import com.example.recipe.ui.recipelist.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {
    lateinit var binding: FragmentRecipeListBinding
    val viewModel: RecipeListViewModel by viewModels()
    val sharedVM: RecipeSharedVM by activityViewModels() // TODO: 1.02.2022  throws exceptıon

    var recipes: List<Recipe>? = listOf(
        Recipe("1", "Source Url 1", "Img Url 1", "Publisher 1", null, "Title 1", null, "Published ID 1"),
        Recipe("2", "Source Url 2", "Img Url 2", "Publisher 2", null, "Title 2", null, "Published ID 2"),
        Recipe("3", "Source Url 3", "Img Url 3", "Publisher 3", null, "Title 3", null, "Published ID 3")
    )
    private val adapter = RecipeAdapter(recipes)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedVM.recipes = recipes
        binding.viewPager.adapter = ViewPagerAdapter(this, 2)

        val tabLayout = binding.tabLayout
        val viewPager = binding.viewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()

//        viewModel.getRecipeList("chicken", 1)
//        observeLiveData()
    }

//    private fun observeLiveData() {
//        viewModel.recipes.observe(viewLifecycleOwner, {
//            recipes = it
//            Log.d("test", "observeLiveData: " + it.toString())
//        })
//    }
}

