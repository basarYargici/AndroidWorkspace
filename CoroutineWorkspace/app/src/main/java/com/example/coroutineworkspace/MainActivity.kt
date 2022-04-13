package com.example.coroutineworkspace

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val TAG = "COROUTINETEST"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exampleOne()
    }

    private fun exampleOne() {
        Log.d(TAG, "Thread name before GlobalScope: ${Thread.currentThread().name} ")
        GlobalScope.launch() {
            Log.d(TAG, "Thread name in GlobalScope: ${Thread.currentThread().name} ")
            Log.d(TAG, doNetworkCall())
        }
        Log.d(TAG, "Thread name after GlobalScope: ${Thread.currentThread().name} ")

    }
    suspend fun doNetworkCall(): String {
        delay(2000)
        return "Network Call Demo"
    }
}