package com.example.recipe.ui.recipelist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe.domain.model.Category
import com.example.recipe.domain.model.RecipeDetail
import com.example.recipe.network.NetworkResult
import com.example.recipe.repository.RecipeRepository
import com.example.recipe.ui.RecipeSharedVM
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private var recipeRepository: RecipeRepository
) : ViewModel() {
    private val _recipes: MutableLiveData<NetworkResult<List<RecipeDetail>>?> = MutableLiveData()
    lateinit var sharedVM: RecipeSharedVM

    val recipes: LiveData<NetworkResult<List<RecipeDetail>>?>
        get() = _recipes

    fun getRecipeList(query: String, page: Int) {
        viewModelScope.launch {
            _recipes.value = NetworkResult.Loading()
            try {

                val result = recipeRepository.getRecipeList(query, page)
                val result2 = recipeRepository.getCategoryList()
                Log.d("TAG", "getRecipeList: ${result2.toString()}")
                result?.let {
                    _recipes.value = NetworkResult.Success(result)
                    return@launch
                }
            } catch (e: Exception) {
                sharedVM.errorMessage = e.message
                _recipes.value = NetworkResult.Error(e.message)
            }
        }
    }
}


