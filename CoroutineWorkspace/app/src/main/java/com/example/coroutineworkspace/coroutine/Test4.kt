package com.example.coroutineworkspace.coroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// coroutines are lightweight
fun main() = runBlocking {
    repeat(100_000) { // launch a lot of coroutines
        launch {
            delay(5000L)
            print(".")
        }
    }
}
// debug: 10 times launch -> 10 times delay -> 10 times print


//fun main() =
//    repeat(100_000) { // launch a lot of coroutines
//        thread {
//            Thread.sleep(5000L)
//            print(".")
//        }
//    }
