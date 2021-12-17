package com.example.gitproject.ui.details

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gitproject.model.UserDetail
import com.example.gitproject.network.ApiClient
import com.example.gitproject.repository.UserDetailRepository
import kotlinx.coroutines.launch

class UserDetailViewModel : ViewModel() {

    val userDetailRepository = UserDetailRepository(ApiClient.apiService)

    private val _userDetails = MutableLiveData<UserDetail>()
    val userDetails: LiveData<UserDetail>
        get() = _userDetails

    fun getByUsername(username: String?) {
        viewModelScope.launch {
            _userDetails.postValue(
                userDetailRepository.getByUsername(username).body()
            )
        }
    }
}