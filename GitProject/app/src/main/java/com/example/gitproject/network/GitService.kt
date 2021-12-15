package com.example.gitproject.network

import com.example.gitproject.model.UserDetail
import com.example.gitproject.model.User
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitService {

    @GET("users")
    suspend fun getAll(): Response<List<User>>

    @GET("users/{username}")
    suspend fun getByUsername(@Path("username") username: String): Response<UserDetail>
}