package com.example.recipe.ui.recipelist.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.recipe.domain.model.Category
import com.example.recipe.ui.recipelist.RecipeFragment

class ViewPagerAdapter(
    var fragment: Fragment,
    var categories: List<Category>
) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = categories.size

    override fun createFragment(position: Int): Fragment {
        return RecipeFragment(tabName = categories[position].title!!)
    }
}