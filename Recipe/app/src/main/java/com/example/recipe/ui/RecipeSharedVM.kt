package com.example.recipe.ui

import androidx.lifecycle.ViewModel
import com.example.recipe.domain.model.RecipeDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeSharedVM @Inject constructor() : ViewModel() {
    var recipes: List<RecipeDetail>? = null
    var errorMessage: String? = "Error"
}
