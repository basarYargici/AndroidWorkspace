package com.example.recipe.network.responses

import com.example.recipe.network.model.RecipeDto
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @field:SerializedName("count")
    var count: Int? = null,
    @field:SerializedName("recipes")
    var recipes: List<RecipeDto>? = null,
)
