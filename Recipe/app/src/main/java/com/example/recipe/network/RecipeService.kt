package com.example.recipe.network

import com.example.recipe.network.responses.CategoryGetResponse
import com.example.recipe.network.responses.RecipeDetailGetResponse
import com.example.recipe.network.responses.RecipeSearchResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RecipeService {
    @GET("recipes")
    suspend fun getRecipeList(
        @Query("q") query: String,
        @Query("page") page: Int,
    ): RecipeSearchResponse

    @GET("recipes/{recipe_id}")
    suspend fun getRecipeDetail(
        @Path("recipe_id") recipe_id: Int,
    ): RecipeDetailGetResponse

    @GET("categories")
    suspend fun getCategoryList(): CategoryGetResponse
}
