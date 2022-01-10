package com.example.codelabworkspace

import retrofit2.Response
import retrofit2.http.GET

interface CommentService {
    @GET("/comments")
    suspend fun getComments(): Response<List<Comment>>
}