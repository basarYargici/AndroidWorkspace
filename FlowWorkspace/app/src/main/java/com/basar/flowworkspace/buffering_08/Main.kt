package com.basar.flowworkspace.buffering_08

import com.basar.flowworkspace.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    var time = measureTimeMillis {
        jediTrainees()
            .collect { jedi ->
                delay(3 * DELAY) // Jedi Master training
                log("Jedi ${jedi.name} is now a Jedi Master")
            }
    }

    // there are 3 trainee and for each collect delays 3 times delay
    // (3*500+3*3*500) = 6000ms is the estimated time
    log("Total time: $time ms")

    exampleOf("buffer")

    time = measureTimeMillis {
        jediTrainees()
            .buffer()
            .collect { jedi ->
                delay(3 * DELAY) // Jedi Master training
                log("Jedi ${jedi.name} is now a Jedi Master")
            }
    }
    // when first jedi's collection is started, 500ms is already passed. While its in collect block which
    // takes 1500 ms, max 3 jedi can be buffered. In our case we have 3 jedi.
    // first jedi = 500(in flow) + 1500(in collect)
    // second and third will come in buffer when first jedi is in collect state. So we do not need to sum
    // their flow times.
    // (1*500+3*3*500) = 5000ms is the estimated time

    log("Total time: $time ms")

    exampleOf("conflate")

    time = measureTimeMillis {
        jediTrainees()
            .conflate()
            .collect { jedi ->
                delay(3 * DELAY) // Jedi Master training
                log("Jedi ${jedi.name} is now a Jedi Master")
            }
    }

    // in conflate, if any two value occurs in the buffer, first came is dropped.
    // in our case at 1000 ms, second jedi is arrived and at 1500 ms third jedi is arrived. Second jedi has
    // not collected. Therefore second jedi is dropped.
    // (500 + 1500 + 1500) = 3500ms is the estimated time
    log("Total time: $time ms")

    exampleOf("collectLatest")

    time = measureTimeMillis {
        jediTrainees()
            .collectLatest { jedi ->
                log("Jedi Master training for ${jedi.name}")
                delay(3 * DELAY) // Jedi Master training
                log("Jedi ${jedi.name} is now a Jedi Master")
            }
    }

    // first jedi is collecting
    // second jedi is collecting
    // third jedi is collecting
    // at 3*500 the latest jedi is the third one. So 3*500 for each training and 1500 for making master the third jedi
    // (3*500+1500) = 3000ms is the estimated time
    log("Total time: $time ms")
}

fun jediTrainees(): Flow<ForceUser> =
    forceUsers.asFlow()
        .transform { forceUser ->
            if (forceUser is Padawan) {
                delay(DELAY) // Jedi Knight training
                emit(forceUser)
            }
        }