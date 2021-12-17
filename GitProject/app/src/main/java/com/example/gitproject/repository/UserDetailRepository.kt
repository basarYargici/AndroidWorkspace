package com.example.gitproject.repository

import com.example.gitproject.model.UserDetail
import com.example.gitproject.network.GitService
import retrofit2.Response

class UserDetailRepository(
    private val gitService: GitService
) {

    suspend fun getByUsername(username: String?): Response<UserDetail> {
        return gitService.getByUsername(username)
    }
}