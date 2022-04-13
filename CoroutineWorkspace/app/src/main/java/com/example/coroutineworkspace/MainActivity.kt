package com.example.coroutineworkspace

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

const val TAG = "COROUTINETEST"

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tv)

//        exampleGlobalScope()
//        exampleRunBlocking()
//        exampleJob()
//        multipleRequestLong()
//        multipleRequestBadApproach()
//        multipleRequestGoodApproach()
//        multipleRequestMakeAsyncLikeLaunch()
    }


    // Meaningless usage of async. You should wait till async is finished like making it sequential
    private fun multipleRequestMakeAsyncLikeLaunch() {
        GlobalScope.launch {
            val time = measureTimeMillis {
                val answer = async { doNetworkCall() }.await()
                val answer1 = async { doNetworkCall2() }.await()
                Log.d(TAG, "Answer is $answer")
                Log.d(TAG, "Answer1 is $answer1")
            }
            Log.d(TAG, "Request took $time ms") // 4000 ms
        }
    }

    /**
     * there are basically two kind of execution
    1. Sequential (Default)
    2. Concurrent(achieved with async{} )
    For instance if we have two function func1() & func2(), execution of func2() is dependent on func1() then
    in that case we can use default version of coroutine and if they are independent of each other then we can
    use concurrent with the help of async{}

    with the sequential execution we run the code sequentially so if func1() takes 5sec for execution and
    func2() takes 3 sec for execution then total elapsed time will be around 8 sec, however when this methods
    are independent and their results are not required for execution of other fun then in that case execution
    can be completed in 5 sec with the help of async(concurrent).

    Async vs launch:
    Async returns Deffered<Type> [Type:: calling function is returning]
    launch returns Job.

    await() -> methods are used to ensure the execution will go further until function is executed completely.
    [e.g func1().await()]

    We can also call async with LAZY pass below value in async constructor.
    val one = async(start = CoroutineStart.LAZY) { func1()) }

    one.start() // start the execution of func1

     */
    // Start coroutine ad return deferred instead of job, can be used to get result
    private fun multipleRequestGoodApproach() {
        GlobalScope.launch {
            val time = measureTimeMillis {
                val answer = async { doNetworkCall() } // last line will be returned
                val answer1 = async { doNetworkCall2() } // last line will be returned
                Log.d(TAG, "Answer is ${answer.await()}")
                Log.d(TAG, "Answer1 is ${answer1.await()}")
            }
            Log.d(TAG, "Request took $time ms") // 2000s
        }
    }


    // Start coroutine and return job
    private fun multipleRequestBadApproach() {
        GlobalScope.launch {
            val time = measureTimeMillis {
                var answer: String? = null
                var answer1: String? = null
                val job = launch { answer = doNetworkCall() }
                val job1 = launch { answer1 = doNetworkCall2() }
                job.join()
                job1.join()
                Log.d(TAG, "Answer is $answer")
                Log.d(TAG, "Answer1 is $answer1")
            }
            Log.d(TAG, "Request took $time ms") // 2000s
        }
    }


    private fun multipleRequestLong() {
        GlobalScope.launch {
            val time = measureTimeMillis {
                val answer = doNetworkCall() // go and finish function, then assign it to variable
                val answer1 = doNetworkCall2()
                Log.d(TAG, "Answer is $answer")
                Log.d(TAG, "Answer1 is $answer1")
            }

            Log.d(TAG, "Request took $time ms") // 4000s
        }
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
        val text = "Network Call Demo"
        return text
    }

    suspend fun doNetworkCall2(): String {
        delay(2000)
        val text = "Network Call2 Demo"
        return text
    }
}