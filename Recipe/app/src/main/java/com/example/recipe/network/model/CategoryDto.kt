package com.example.recipe.network.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryDto(
    val categories: List<CategoryItemDto>? = null
) : Parcelable

@Parcelize
data class CategoryItemDto(
    val imageUrl: String? = null,
    val title: String? = null
) : Parcelable
