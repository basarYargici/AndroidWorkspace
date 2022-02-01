package com.example.recipe.ui

import androidx.lifecycle.ViewModel
import com.example.recipe.domain.model.Recipe

data class RecipeSharedVM(
    var recipes: List<Recipe>? = null
) : ViewModel()
