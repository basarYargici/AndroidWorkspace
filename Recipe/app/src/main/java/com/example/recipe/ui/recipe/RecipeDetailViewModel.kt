package com.example.recipe.ui.recipe

import androidx.lifecycle.ViewModel
import com.example.recipe.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeDetailViewModel @Inject constructor(
    private var recipeRepository: RecipeRepository,
) : ViewModel() {

}