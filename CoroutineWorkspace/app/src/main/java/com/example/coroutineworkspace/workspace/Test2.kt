package com.example.coroutineworkspace.workspace

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// Sequentially executes doWorld followed by "Done"
fun main() = runBlocking {
    doWorld()
    doWorld() // runBlocking blocks the underlying thread, does not execute this line before 10 finished
    println("Done")
}

// Concurrently executes both sections
suspend fun doWorld() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}
// coroutineScope line debug: 16 -> 20 -> 24 -> 17 ..