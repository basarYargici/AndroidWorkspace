package com.example.recipe.ui.recipelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recipe.domain.model.RecipeDetail
import com.example.recipe.network.NetworkResult
import com.example.recipe.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RecipeViewModel @Inject constructor(
    private var recipeRepository: RecipeRepository
) : ViewModel() {

    private val _recipes: MutableLiveData<NetworkResult<List<RecipeDetail>>?> = MutableLiveData()
    val recipes: LiveData<NetworkResult<List<RecipeDetail>>?>
        get() = _recipes

    suspend fun getRecipeList(query: String, page: Int) {
        _recipes.value = NetworkResult.Loading()
        try {
            val result = recipeRepository.getRecipeList(query, page)
            result?.let {
                _recipes.value = NetworkResult.Success(result)
            }
        } catch (e: Exception) {
            _recipes.value = NetworkResult.Error(e.message)
        }
    }

}