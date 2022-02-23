package com.example.recipe.ui.recipelist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recipe.domain.model.Category
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
    private val _categories: MutableLiveData<NetworkResult<List<Category>>?> = MutableLiveData()
    lateinit var sharedVM: RecipeSharedVM

    val categories: LiveData<NetworkResult<List<Category>>?>
        get() = _categories


    suspend fun getCategoryList() {
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


fun ViewModel.launch(block: suspend () -> Unit): Job = viewModelScope.launch {
    block()
}