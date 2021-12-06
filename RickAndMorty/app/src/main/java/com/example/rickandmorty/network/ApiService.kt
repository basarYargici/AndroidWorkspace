package com.example.rickandmorty.network

import com.example.rickandmorty.model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("character")
    fun getAll(@Query("page") page: String): Call<CharacterResponse>
}