package com.example.retrofit

data class Todo(
    val id: Int,
    val userId: Int,
    val completed: Boolean,
    val title: String
)