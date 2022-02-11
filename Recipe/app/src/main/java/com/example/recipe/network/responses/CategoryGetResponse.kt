package com.example.recipe.network.responses

import com.example.recipe.network.model.category.CategoryDto
import com.google.gson.annotations.SerializedName

data class CategoryGetResponse(
    @field:SerializedName("categories")
    val categories: List<CategoryDto>? = null
)