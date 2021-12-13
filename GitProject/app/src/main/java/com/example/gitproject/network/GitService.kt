package com.example.gitproject.network

import com.example.gitproject.model.User
import com.example.gitproject.model.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {

    @GET("users")
    fun getAll(): Call<Users>

    @GET("users/{username}")
    fun getByUsername(@Path("username") username: String): Call<User>
}