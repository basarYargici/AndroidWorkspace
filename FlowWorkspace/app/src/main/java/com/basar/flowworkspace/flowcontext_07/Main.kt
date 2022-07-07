package com.basar.flowworkspace.flowcontext_07

import com.basar.flowworkspace.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

/*
* Coroutine context provides configs in which a coroutine run.
*
* CoroutineContext:
* - ContinuationInterceptor (Determine thread pool and in which coroutine runs. Ex: Dispatchers)
* - ExceptionHandler
*
*/
fun main() = runBlocking {
    fun duelOfTheFates(): Flow<ForceUser> = flow {
        for (forceUser in forceUsers) {
            delay(DELAY)
            log("Battling ${forceUser.name}")
            emit(forceUser)
        }
    }
        .flowOn(Dispatchers.Default) // Flow's dispatcher changed to Default and below is still on main thread
        .transform { forceUser ->
            if (forceUser is Sith) {
                forceUser.name = "MyDarth ${forceUser.name}"
            }
            emit(forceUser)
        }

    duelOfTheFates().collect {
        log("Battled ${it.name}")
    }
}
