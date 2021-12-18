package com.example.gitproject.ui.home

import com.example.gitproject.model.User

interface UserListener {
    fun onUserSelected(user: User)
}