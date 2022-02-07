package com.example.recipe.repository

import com.example.recipe.domain.model.CategoryList
import com.example.recipe.domain.model.Recipe
import com.example.recipe.network.RecipeService
import com.example.recipe.network.model.CategoryDtoMapper
import com.example.recipe.network.model.RecipeDtoMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper,
    private val categoryDtoMapper: CategoryDtoMapper
) : RecipeRepository {
    override suspend fun getRecipe(recipe_id: Int): Recipe? {
        return recipeService.getRecipe(recipe_id).recipe?.let {
            mapper.mapToDomainModel(it)
        }
    }

    override suspend fun getCategoryList(): CategoryList?  {
        return recipeService.getCategoryList().let {
            it.categories?.let { it1 -> categoryDtoMapper.mapToDomainModel(it1) }
        }
    }

    override suspend fun getRecipeList(query: String, page: Int): List<Recipe>? {
        return recipeService.getRecipeList(query, page).recipes?.let {
            mapper.fromDtoListToModel(it)
        }
    }
}