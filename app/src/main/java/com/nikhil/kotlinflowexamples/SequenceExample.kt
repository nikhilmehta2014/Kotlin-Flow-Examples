package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

/**
 * Sequences are very similar to lists. But unlike lists, they are lazily evaluated.
 * This means they produce values as you iterate over them, instead of producing them all at once.
 */
private suspend fun getValues(): Sequence<Int> = sequence {
    Thread.sleep(250)
    yield(1)
    Thread.sleep(250)
    yield(2)
    Thread.sleep(250)
    yield(3)
}


private fun processValues() {
    runBlocking {
        val values = getValues()
        for (value in values) {
            println(value)
        }
    }
}

/**
 * You’ll get the same output as before, but this time you won’t have to wait for all the values.
 * You’ll produce and consume them, one at a time.
 *
 * Sequences use Iterators under the hood and block while waiting for the next item.
 *
 * You can use Sequences for synchronous streams.
 */
fun main() {
    processValues()
}