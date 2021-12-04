package com.example.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {

//    private val url :String =  "https://jsonplaceholder.typicode.com/"

    @GET("/todos")
    suspend fun getTodos(): Response<List<Todo>>

//    @GET("/todo")
//    fun getTodos(@Query("key") key: String): Response<List<Todo>>
//
//    @POST("/todoadd")
//    fun createTodo(@Body todo: Todo): Response<Todo>
}