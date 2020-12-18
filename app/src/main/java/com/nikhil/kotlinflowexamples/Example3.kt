package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

/**
 * Flow adheres to the general cooperative cancellation of coroutines.
 *
 * As usual, flow collection can be cancelled when the flow is suspended in a cancellable
 * suspending function (like [delay]).
 */
private fun simple(): Flow<Int> = flow {
    for (i in 1..3) {
        delay(100)
        println("Emitting $i")
        emit(i)
    }
}

@InternalCoroutinesApi
fun main() = runBlocking<Unit> {
    withTimeoutOrNull(250) { // Timeout after 250ms
        simple().collect { value ->
            println(value)
        }
    }
    println("Done")
}