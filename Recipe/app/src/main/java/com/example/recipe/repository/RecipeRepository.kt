package com.example.recipe.repository

import com.example.recipe.domain.model.Recipe

interface RecipeRepository {
    suspend fun getRecipe(recipe_id: Int): Recipe?
    suspend fun getRecipeList(query: String, page: Int): List<Recipe>?
}