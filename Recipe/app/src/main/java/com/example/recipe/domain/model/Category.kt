package com.example.recipe.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
//
//@Parcelize
//data class CategoryList(
//    @field:SerializedName("categories")
//    val categories: List<Category>? = null
//) : Parcelable

@Parcelize
data class Category(
    @field:SerializedName("imageUrl")
    val imageUrl: String? = null,

    @field:SerializedName("title")
    val title: String? = null
) : Parcelable
