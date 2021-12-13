package com.example.gitproject.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.gitproject.databinding.ActivityMainBinding
import com.example.gitproject.model.User
import com.example.gitproject.model.Users
import com.example.gitproject.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var users: Users
    private lateinit var user: User

    private val TAG = "MAINACTIVITY"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getAll()
        getByUsername("basarYargici")
    }

    private fun getAll() {
        ApiClient.apiService.getAll().enqueue(object : Callback<Users> {
            override fun onResponse(call: Call<Users>, response: Response<Users>) {
                users = response.body()!!
                Log.e(TAG, users.toString())
            }

            override fun onFailure(call: Call<Users>, t: Throwable) {
                Log.e(TAG, t.message.toString())
            }
        })
    }

    private fun getByUsername(username: String) {
        ApiClient.apiService.getByUsername(username).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                user = response.body()!!
                Log.e(TAG, user.toString())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                Log.e(TAG, call.request().url.toString())

                Log.e(TAG, t.message.toString())
            }
        })
    }

}