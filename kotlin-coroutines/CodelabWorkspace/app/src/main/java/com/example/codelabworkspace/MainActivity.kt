package com.example.codelabworkspace

import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    /**
     * LESSON-1
     * Start and Delay coroutines
     */
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        Log.d(TAG, "Main-1 thread ${Thread.currentThread().name}")
//        GlobalScope.launch {
//            Log.d(TAG, "Coroutine from thread ${Thread.currentThread().name}")
//            delay(3000)
//            Log.d(TAG, "Coroutine from thread ${Thread.currentThread().name}")
//        }
//        Log.d(TAG, "Main-2 thread ${Thread.currentThread().name}")
//    }

    /**
     * LESSON-2
     * Suspend function can only executed by another suspend function or inside of coroutine
     */
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        Log.d(TAG, "Main-1 thread ${Thread.currentThread().name}")
//        GlobalScope.launch {
//            val simulateNetworkAnswer = simulateNetworkCall()
//            val simulateNetworkAnswer2 = simulateNetworkCall2()
//            Log.d(TAG, simulateNetworkAnswer+simulateNetworkAnswer2)
//
//        }
//        Log.d(TAG, "Main-2 thread ${Thread.currentThread().name}")
//    }
//
//    suspend fun simulateNetworkCall(): String {
//        Log.d(TAG, "Coroutine from thread ${Thread.currentThread().name}")
//        delay(3000)
//        return "JSON RESPONSE"
//    }
//
//    suspend fun simulateNetworkCall2(): String {
//        Log.d(TAG, "Coroutine from thread ${Thread.currentThread().name}")
//        delay(3000)
//        return "JSON RESPONSE2"
//    }

    /**
     * LESSON-3
     * Dispatcher to select thread
     *      Main -> UI
     *      IO -> Data operations like save to db or make a network call
     *      Default -> long running operations
     */
//    lateinit var tv: TextView
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        tv = findViewById<TextView>(R.id.tvHello)
//        tv.text = "not delayed"
//    }
//
//    override fun onResume() {
//        super.onResume()
//        GlobalScope.launch(Dispatchers.IO) {
//            Log.d(TAG, "starting delay coroutine in thread ${Thread.currentThread().name}")
//            delay(3000)
//            withContext(Dispatchers.Main) {
//                Log.d(TAG, "setting text coroutine in thread ${Thread.currentThread().name}")
//                tv.text = "delayed 3s"
//            }
//        }
//    }

    /**
     * LESSON-4
     * runBlocking locks main thread. We can call suspend functions in runBlocking.
     *
     */
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        Log.d(TAG, "onCreate: Before runBlocking")
//
//        runBlocking {
//            Log.d(TAG, "onCreate: Start of runBlocking")
//            delay(3000)
//            Log.d(TAG, "onCreate: End of runBlocking")
//        }
//        Log.d(TAG, "onCreate: After runBlocking")
//    }
}