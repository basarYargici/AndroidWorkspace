package com.example.gitproject.repository

import com.example.gitproject.model.User
import com.example.gitproject.network.GitService
import retrofit2.Response

class UserRepository(
    private val gitService: GitService
) {

    suspend fun getAll(): Response<List<User>> {
        return gitService.getAll()
    }
}