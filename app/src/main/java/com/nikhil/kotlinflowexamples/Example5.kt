package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

/**
 * Flow operators
 */

/*suspend fun performRequest(request: Int): String {
    delay(1000) // imitate long-running asynchronous work
    return "response $request"
}*/

/**
 * 1
 *
 * Flows can be transformed with operators, just as you would with collections and sequences.
 *
 * These operators are cold, just like flows are.
 *
 * The important difference to sequences is that blocks of code inside these operators can call suspending functions.
 */
/*fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .map { request ->
            performRequest(request)
        }
        .collect { response ->
            println(response)
        }
}*/

/**
 * 2
 *
 * Using the [transform] operator, we can emit arbitrary values an arbitrary number of times.
 */
/*fun main() = runBlocking<Unit> {
    (1..3).asFlow() // a flow of requests
        .transform { request ->
            emit("Making request $request")
            emit(performRequest(request))
        }
        .collect { response -> println(response) }
}*/

/**
 * 3
 *
 * Size-limiting operators
 */
/*fun numbers(): Flow<Int> = flow {
    try {
        emit(1)
        emit(2)
        println("This line will not execute")
        emit(3)
    } finally {
        println("Finally in numbers")
    }
}

fun main() = runBlocking<Unit> {
    numbers()
        .take(2) // take only the first two
        .collect { value -> println(value) }
}*/

/**
 * 4
 *
 * Terminal flow operators
 *
 * Terminal operators on flows are [suspending] functions that start a collection of the flow.
 */
fun main() = runBlocking<Unit> {
    val sum = (1..5).asFlow()
        .map { it * it } // squares of numbers from 1 to 5
        .reduce { a, b -> a + b } // sum them (terminal operator)
    println(sum)
}
