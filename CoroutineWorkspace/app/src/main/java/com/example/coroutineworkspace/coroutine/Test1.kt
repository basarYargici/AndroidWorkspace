package com.example.coroutineworkspace.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking { // this: CoroutineScope
    launch { // launch a new com.example.coroutineworkspace.coroutine and continue
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }

    println("Hello") // main com.example.coroutineworkspace.coroutine continues while a previous one is delayed
    println("Hello1") // main com.example.coroutineworkspace.coroutine continues while a previous one is
    // delayed

    runBlocking {
        println("Hello") // main com.example.coroutineworkspace.coroutine continues while a previous one is delayed
        delay(1000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
        delay(8000L) // non-blocking delay for 1 second (default time unit is ms)
        println("World!") // print after delay
    }
}
