package com.example.recipe.repository

import com.example.recipe.domain.model.Category
import com.example.recipe.domain.model.RecipeDetail
import com.example.recipe.network.RecipeService
import com.example.recipe.network.model.category.CategoryDtoMapper
import com.example.recipe.network.model.recipe.RecipeDetailDtoMapper

class RecipeRepositoryImpl(
    private val recipeService: RecipeService,
    private val mapper: RecipeDetailDtoMapper,
    private val categoryDtoMapper: CategoryDtoMapper
) : RecipeRepository {
    override suspend fun getRecipe(recipe_id: Int): RecipeDetail? {
        return recipeService.getRecipeDetail(recipe_id).recipe?.let {
            mapper.mapToDomainModel(it)
        }
    }

    override suspend fun getCategoryList(): List<Category>? {
        return recipeService.getCategoryList().let {
            it.categories?.let { it1 ->
                categoryDtoMapper.fromDtoListToModel(it1)
            }
        }
    }

    override suspend fun getRecipeList(query: String, page: Int): List<RecipeDetail>? {
        return recipeService.getRecipeList(query, page).recipes?.let {
            mapper.fromDtoListToModel(it)
        }
    }
}