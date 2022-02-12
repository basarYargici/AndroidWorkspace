package com.example.recipe.ui.recipelist

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
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RecipeListViewModel @Inject constructor(
    private var recipeRepository: RecipeRepository
) : ViewModel() {
    private val _recipes: MutableLiveData<NetworkResult<List<RecipeDetail>>?> = MutableLiveData()
    private val _categories: MutableLiveData<NetworkResult<List<Category>>?> = MutableLiveData()
    lateinit var sharedVM: RecipeSharedVM

    val recipes: LiveData<NetworkResult<List<RecipeDetail>>?>
        get() = _recipes
    val categories: LiveData<NetworkResult<List<Category>>?>
        get() = _categories

    fun getRecipeList(query: String, page: Int) {
        launch {
            _recipes.value = NetworkResult.Loading()
            try {
                val result = recipeRepository.getRecipeList(query, page)
                result?.let {
                    _recipes.value = NetworkResult.Success(result)
                }
            } catch (e: Exception) {
                sharedVM.errorMessage = e.message
                _recipes.value = NetworkResult.Error(e.message)
            }
        }
    }

    fun getCategoryList() {
        launch {
            _categories.value = NetworkResult.Loading()
            try {
                val result = recipeRepository.getCategoryList()
                result?.let {
                    _categories.value = NetworkResult.Success(result)
                }
            } catch (e: Exception) {
                sharedVM.errorMessage = e.message
                _categories.value = NetworkResult.Error(e.message)
            }
        }
    }
}


private fun ViewModel.launch(block: suspend () -> Unit): Job = viewModelScope.launch {
    block()
}