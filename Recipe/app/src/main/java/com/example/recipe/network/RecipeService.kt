package com.example.recipe.network

import com.example.recipe.network.responses.RecipeGetResponse
import com.example.recipe.network.responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("recipes2")
    suspend fun getRecipeList(
        @Query("q") query: String,
        @Query("page") page: Int,
    ): RecipeSearchResponse

    @GET("recipes/{recipe_id}")
    suspend fun getRecipe(
        @Path("recipe_id") recipe_id: Int,
    ): RecipeGetResponse
}