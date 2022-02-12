package com.example.recipe.ui.recipelist.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.recipe.domain.model.RecipeDetail
import com.example.recipe.ui.recipelist.RecipeViewPageFragment

class ViewPagerAdapter(
    var fragment: Fragment,
    var categoriesSize: Int,
    var recipes: List<RecipeDetail>?,
    var adapter: RecipeAdapter,
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = categoriesSize

    override fun createFragment(position: Int): Fragment {
        return RecipeViewPageFragment(recipes,adapter)
    }
}