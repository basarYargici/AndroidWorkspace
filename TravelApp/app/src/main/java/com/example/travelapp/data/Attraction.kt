package com.example.travelapp.data

import com.google.gson.annotations.SerializedName

data class Attraction(
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("facts")
    val facts: List<String>? = null,
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("image_urls")
    val imageUrls: List<String>? = null,
    @SerializedName("location")
    val location: Location? = null,
    @SerializedName("months_to_visit")
    val monthsToVisit: String? = null,
    @SerializedName("title")
    val title: String? = null
)