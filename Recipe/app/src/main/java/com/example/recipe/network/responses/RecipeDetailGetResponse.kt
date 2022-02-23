package com.example.recipe.network.responses

import com.example.recipe.network.model.recipe.RecipeDetailDto
import com.google.gson.annotations.SerializedName

data class RecipeDetailGetResponse(
    @field:SerializedName("recipe")
    val recipe: RecipeDetailDto? = null
)
