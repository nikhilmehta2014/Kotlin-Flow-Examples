package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.System.currentTimeMillis

/**
 * Composing multiple flows
 */

//Zip - combines the corresponding values of two flows
/*fun main() = runBlocking<Unit> {
    val nums = (1..3).asFlow() // numbers 1..3
    val strs = flowOf("one", "two", "three") // strings
    nums.zip(strs) { a, b ->
        "$a -> $b"  // compose a single string
    }
        .collect {
            println(it)
        }
}*/

//Combine - Returns a [Flow] whose values are generated with [transform] function by combining
// the most recently emitted values by each flow.
fun main() = runBlocking<Unit> {
    val nums = (1..3).asFlow().onEach { delay(300) } // numbers 1..3 every 300 ms
    val strs = flowOf("one", "two", "three").onEach { delay(400) } // strings every 400 ms
    val startTime = currentTimeMillis() // remember the start time
    nums.combine(strs) { a, b -> "$a -> $b" } // compose a single string with "combine"
        .collect { value -> // collect and print
            println("$value at ${currentTimeMillis() - startTime} ms from start")
        }
}

