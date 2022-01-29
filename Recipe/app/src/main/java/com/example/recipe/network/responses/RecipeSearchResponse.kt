package com.example.recipe.network.responses

import com.example.recipe.domain.model.Recipe
import com.google.gson.annotations.SerializedName

data class RecipeSearchResponse(
    @SerializedName("count")
    var count: Int? = null,
    @SerializedName("recipes")
    var recipes: List<Recipe>? = null,
)
