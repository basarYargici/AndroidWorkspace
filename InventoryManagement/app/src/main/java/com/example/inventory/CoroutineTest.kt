import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay

suspend fun main() {

    // simulate some compute sensitive task
    suspend fun task1(): Int {
        delay(100)
        return 10
    }

    // simulate some compute sensitive task
    suspend fun task2(): Int {
        delay(200)
        return 20
    }

    // 1. performs tasks parallely
    // 2. waits for all tasks to finish
    // 3. usage computed results of all tasks and returns addition of those
    suspend fun doTask() = coroutineScope {
        val result1 = async { task1() }
        val result2 = async { task2() }
        result1.await()
        +
        result2.await()
    }

    println(doTask())
}