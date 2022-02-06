package com.example.recipe.ui

import androidx.lifecycle.ViewModel
import com.example.recipe.domain.model.Recipe
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeSharedVM @Inject constructor() : ViewModel() {
    var recipes: List<Recipe>? = null
    var errorMessage: String? = "Error"
}
