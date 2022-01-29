package com.example.recipe.network.responses

import com.example.recipe.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeGetResponse(
    @field:SerializedName("recipe")
    val recipe: RecipeDto? = null
)
