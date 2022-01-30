package com.example.recipe.ui.recipelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe.domain.model.Recipe
import com.example.recipe.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private var recipeRepository: RecipeRepository
) : ViewModel() {
    private val _recipes = MutableLiveData<List<Recipe>?>()
    val recipes: LiveData<List<Recipe>?>
        get() = _recipes

    fun getRecipeList(query: String, page: Int) {
        viewModelScope.launch {
            _recipes.postValue(recipeRepository.getRecipeList(query, page))
        }
    }
}