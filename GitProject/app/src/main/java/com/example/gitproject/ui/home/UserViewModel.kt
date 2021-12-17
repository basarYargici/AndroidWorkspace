package com.example.gitproject.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitproject.model.User
import com.example.gitproject.network.ApiClient
import com.example.gitproject.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {

    private val userRepository = UserRepository(ApiClient.apiService)

    private val _users = MutableLiveData<List<User>>()
    val responseData: LiveData<List<User>>
        get() = _users

    fun getAll() {
        viewModelScope.launch {
            _users.postValue(
                userRepository.getAll().body()
            )
        }
    }
}