package com.example.recipe.network.model

import com.google.gson.annotations.SerializedName

data class RecipeDto(
    @field:SerializedName("id")
    val id: String? = null,

    @field:SerializedName("sourceUrl")
    val sourceUrl: String? = null,

    @field:SerializedName("imageUrl")
    val imageUrl: String? = null,

    @field:SerializedName("publisher")
    val publisher: String? = null,

    @field:SerializedName("ingredients")
    val ingredients: List<String?>? = null,

    @field:SerializedName("title")
    val title: String? = null,

    @field:SerializedName("socialUrl")
    val socialUrl: Double? = null,

    @field:SerializedName("publishedId")
    val publishedId: String? = null
)
