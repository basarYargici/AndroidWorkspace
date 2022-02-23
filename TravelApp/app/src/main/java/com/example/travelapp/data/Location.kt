package com.example.travelapp.data

import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("latitude")
    val latitude: String? = null,
    @SerializedName("longitude")
    val longitude: String? = null
)