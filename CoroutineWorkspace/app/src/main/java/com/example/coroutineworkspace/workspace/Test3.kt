package com.example.coroutineworkspace.workspace

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job = launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("World!")
    }
    println("Hello")
    println(job.onJoin) // active -> job has not finished
    job.join() // wait until child coroutine completes
    println(job.onJoin) // completed -> job has finished
    println("Done")
}