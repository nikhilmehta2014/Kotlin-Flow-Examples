package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * Flows are sequential
 *
 * Each emitted value is processed by all the intermediate operators from upstream to downstream and
 * is then delivered to the terminal operator after.
 */
fun main() = runBlocking<Unit> {
    (1..5).asFlow()
        .filter {
            println("Filter $it")
            it % 2 == 0
        }
        .map {
            println("Map $it")
            "string $it"
        }.collect {
            println("Collect $it")
        }
}