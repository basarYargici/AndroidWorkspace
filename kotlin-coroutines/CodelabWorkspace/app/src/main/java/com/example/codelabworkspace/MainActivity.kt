package com.example.codelabworkspace

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    val TAG = "MainActivity"

    //region Lesson-1
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
    //endregion

    //region Lesson-2
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
    //endregion

    //region Lesson-3
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
    //endregion

    //region Lesson-4
    /**
     * LESSON-4
     * Job: cancellable, can be assigned to variable
     */
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val job: Job = GlobalScope.launch(Dispatchers.Default) {
//            repeat(5) {
//                Log.d(TAG, "Coroutine is working..")
//                delay(1000)
//            }
//        }
//
//        val job2: Job = GlobalScope.launch(Dispatchers.Default) {
//            // check if job is cancelled
//            if (isActive) {
//                Log.d(TAG, "Coroutine is working..")
//            }
//        }
//
//        val job3: Job = GlobalScope.launch(Dispatchers.Default) {
//            // if timeout passes, cancels job
//            withTimeout(3000) {
//                if (isActive) {
//                    Log.d(TAG, "Coroutine is working..")
//                }
//            }
//        }
//
//        runBlocking {
//            delay(2000)
//            job.join() // block until finishes
//            job.cancel() // block until cancel job
//            Log.d(TAG, "Mainthread is continuing")
//        }
//    }
    //endregion

    //region Lesson-5
    /**
     * LESSON-5
     * async returns deferred, launch returns job.
     * await will wait for result
     */
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        // as sync
//        GlobalScope.launch(Dispatchers.IO) {
//            val time = measureTimeMillis {
//                val answer1 = networkCall1()
//                val answer2 = networkCall2()
//                Log.d(TAG, "Answer1 is $answer1")
//                Log.d(TAG, "Answer2 is $answer2")
//            }
//            Log.d(TAG, "Took millis $time")
//        }
//
//        // bad practice
//        GlobalScope.launch(Dispatchers.IO) {
//            val time = measureTimeMillis {
//                var answer1: String? = null
//                var answer2: String? = null
//                val job1 = launch { answer1 = networkCall1() }
//                val job2 = launch { answer2 = networkCall1() }
//                job1.join()
//                job2.join()
//                Log.d(TAG, "Answer1 is $answer1")
//                Log.d(TAG, "Answer2 is $answer2")
//            }
//            Log.d(TAG, "Took millis $time")
//        }
//
//        // instead use async
//        // use async when return a value which will be used
//        GlobalScope.launch(Dispatchers.IO) {
//            val time = measureTimeMillis {
//                var answer1 = async {
//                    networkCall1()
//                }
//                var answer2 = async {
//                    networkCall2()
//                }
//
//                Log.d(TAG, "Answer1 is ${answer1.await()}")
//                Log.d(TAG, "Answer2 is ${answer2.await()}")
//            }
//            Log.d(TAG, "Took millis $time")
//        }
//
//    }
//
//    suspend fun networkCall1(): String {
//        delay(3000)
//        return "Answer 1"
//    }
//
//    suspend fun networkCall2(): String {
//        delay(3000)
//        return "Answer 2"
//    }
    //endregion

    //region Lesson-6
    /**
     * LESSON-6
     * GlobalScope can cause memory leaks if not used efficiently
     * lifecycleScope or viewModelScope should be preferred
     */
    //
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        var btn = findViewById<Button>(R.id.btnStartActivity)
//
//        // bad practice
//        btn.setOnClickListener {
//            GlobalScope.launch {
//                while (true) {
//                    delay(1000)
//                    Log.d(TAG, "Still running")
//                }
//            }
//            GlobalScope.launch {
//                delay(5000)
//                Intent(this@MainActivity, SecondActivity::class.java).also {
//                    startActivity(it)
//                    finish()
//                }
//            }
//        }
//
//        // good practice
//        btn.setOnClickListener {
//            lifecycleScope.launch {
//                while (true) {
//                    delay(1000)
//                    Log.d(TAG, "Still running")
//                }
//            }
//            GlobalScope.launch {
//                delay(5000)
//                Intent(this@MainActivity, SecondActivity::class.java).also {
//                    startActivity(it)
//                    finish()
//                }
//            }
//        }
//    }
    //endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val time = measureTimeMillis {
            lifecycleScope.launch {
                var comments = ApiClient.apiService.getComments()
                if (comments.isSuccessful) {
                    for (comment in comments.body()!!) {
                        Log.d(TAG, "${comment.body}")
                    }
                }
            }
        }
        Log.d(TAG, "time in lifecycleScope $time")

        val time2 = measureTimeMillis {
            GlobalScope.launch {
                var comments = ApiClient.apiService.getComments()
                if (comments.isSuccessful) {
                    for (comment in comments.body()!!) {
                        Log.d(TAG, "${comment.body}")
                    }
                }
            }
        }
        Log.d(TAG, "time in GlobalScope $time2")
    }
}
