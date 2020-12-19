package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * A suspending function asynchronously returns a single value, but how can we return
 * multiple asynchronously computed values?
 *
 * This is where Kotlin Flows come in.
 */

/*fun main() {
    simple().forEach { value ->
        println(value)
    }
}*/

/*fun main() = runBlocking<Unit> {
    simple().forEach { value -> println(value) }
}*/

/*@InternalCoroutinesApi
fun main() = runBlocking<Unit> {
    println("4. Thread name = ${Thread.currentThread().name}")
    // Launch a concurrent coroutine to check if the main thread is blocked
    launch {
        println("4. Thread name 2= ${Thread.currentThread().name}")
        for (k in 1..3) {
            println("I'm not blocked $k")
            delay(100)
        }
    }
    // Collect the flow
    simple().collect { value ->
        println(value)
    }
}*/

/**
 * 1.
 * Simplest way to get Multiple values using Kotlin collections
 */
//fun simple(): List<Int> = listOf(1, 2, 3)

/**
 * 2.
 * If we are computing the numbers with some CPU-consuming blocking code (each computation taking 100ms), then we can represent the numbers using a [Sequence]:
 *
 * However, this computation blocks the main thread that is running the code.
 *
 */
/*fun simple(): Sequence<Int> = sequence { // sequence builder
    for (i in 1..3) {
        Thread.sleep(1000) // pretend we are computing it
        yield(i) // yield next value
    }
}*/

/**
 * 3.
 * We can mark the simple function with a suspend modifier, so that it can perform its work without blocking and return the result as a list
 */
/*suspend fun simple(): List<Int> {
    delay(1000) // pretend we are doing something asynchronous here
    return listOf(1, 2, 3)
}*/

/**
 * 4.
 * Using the [List<Int>] result type, means we can only return all the values at once.
 *
 * To represent the stream of values that are being asynchronously computed, we can use a Flow<Int> type just like
 * we would use the Sequence<Int> type for synchronously computed values:
 *
 * This code waits 100ms before printing each number without blocking the main thread.
 * This is verified by printing "I'm not blocked" every 100ms from a separate coroutine that is running in the main thread:
 */
/*
private fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(1000) // pretend we are doing something useful here
//    Thread.sleep(1000)
        emit(i) // emit next value
    }
}*/
