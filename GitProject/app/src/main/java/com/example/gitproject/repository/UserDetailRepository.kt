package com.example.gitproject.repository

import com.example.gitproject.model.Repository
import com.example.gitproject.model.UserDetail
import com.example.gitproject.network.GitService
import retrofit2.Response
import retrofit2.http.Path

class UserDetailRepository(
    private val gitService: GitService
) {

    suspend fun getByUsername(username: String?): Response<UserDetail>? {
        return gitService.getByUsername(username)
    }

    suspend fun getUserRepositories(username: String?): Response<List<Repository>>? {
        return gitService.getUserRepositories(username)
    }
}