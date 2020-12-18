package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

/**
 * Flows are cold streams similar to sequences — the code inside a flow builder does not run until the flow is collected.
 *
 * This is a key reason the simple function (which returns a flow) is not marked with [suspend] modifier.
 */
private fun simple(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

@InternalCoroutinesApi
fun main() = runBlocking<Unit> {
    println("Calling simple function...")
    val flow = simple()
    println("Calling collect...")
    flow.collect { value ->
        println(value)
    }
    println("Calling collect again...")
    flow.collect { value ->
        println(value)
    }
}