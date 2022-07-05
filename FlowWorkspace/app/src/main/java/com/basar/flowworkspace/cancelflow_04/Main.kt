package com.basar.flowworkspace.cancelflow_04

import com.basar.flowworkspace.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() = runBlocking {

    fun starWarsSounds() = flow {
        for (sound in listOf(chewieSound, r2d2Sound, blasterSound, saberSound)) {
            delay(DELAY) // 500L
            log("Emitting $sound")
            emit(sound)
        }
    }

    // after 3100L, collecting will be canceled
    withTimeoutOrNull((3.1 * DELAY).toLong()) {
        starWarsSounds().collect { sound ->
            log(sound) }
    }

    log("Done emitting sounds")
}
