package com.example.gitproject.ui.home

import com.example.gitproject.model.User

interface UserDetailListener {
    fun onUserSelected(user: User)
}