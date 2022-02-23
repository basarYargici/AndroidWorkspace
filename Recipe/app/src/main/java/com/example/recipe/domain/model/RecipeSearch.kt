package com.example.recipe.domain.model

data class RecipeSearch(
    var count: Int? = null,
    var recipes: List<RecipeDetail>? = null
)