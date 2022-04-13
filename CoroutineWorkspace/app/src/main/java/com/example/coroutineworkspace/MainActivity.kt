package com.example.coroutineworkspace

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

const val TAG = "COROUTINETEST"

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tv)

//        exampleGlobalScope()
//        exampleRunBlocking()
        exampleJob()
    }

    private fun exampleJob() {
        var response = ""
        val job = GlobalScope.launch {
            delay(2000)
            response = doNetworkCall()
        }

        Log.d(TAG, "Thread name before runBlocking: ${Thread.currentThread().name} ")
        runBlocking {
            // Thread will not change in runBlocking. Main thread will continue in this scope and waits
            // till the end of the scope
            Log.d(TAG, "Thread name in runBlocking: ${Thread.currentThread().name} ")
            job.join()
            textView.text = response
        }
        Log.d(TAG, "Thread name after runBlocking: ${Thread.currentThread().name} ")
    }


    private fun exampleRunBlocking() {
        Log.d(TAG, "Thread name before runBlocking: ${Thread.currentThread().name} ")
        runBlocking {
            // Thread will not change in runBlocking. Main thread will continue in this scope and waits
            // till the end of the scope
            Log.d(TAG, "Thread name in runBlocking: ${Thread.currentThread().name} ")
            Log.d(TAG, doNetworkCall())
            textView.text = doNetworkCall()
        }
        Log.d(TAG, "Thread name after runBlocking: ${Thread.currentThread().name} ")
    }

    private fun exampleGlobalScope() {
        Log.d(TAG, "Thread name before GlobalScope: ${Thread.currentThread().name} ")
        GlobalScope.launch() {
            Log.d(TAG, "Thread name in GlobalScope: ${Thread.currentThread().name} ")
            val response = doNetworkCall()
            withContext(Dispatchers.Main) {
                textView.text = response
            }
        }
        Log.d(TAG, "Thread name after GlobalScope: ${Thread.currentThread().name} ")
    }

    suspend fun doNetworkCall(): String {
        delay(2000)
        return "Network Call Demo"
    }
}