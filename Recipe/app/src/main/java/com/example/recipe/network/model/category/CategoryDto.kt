package com.example.recipe.network.model.category

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CategoryDto(
    val imageUrl: String? = null,
    val title: String? = null
) : Parcelable
