package com.example.recipe.repository

import com.example.recipe.domain.model.Category
import com.example.recipe.domain.model.RecipeDetail

interface RecipeRepository {
    suspend fun getRecipe(recipe_id: Int): RecipeDetail?
    suspend fun getCategoryList(): List<Category>?
    suspend fun getRecipeList(query: String, page: Int): List<RecipeDetail>?
}