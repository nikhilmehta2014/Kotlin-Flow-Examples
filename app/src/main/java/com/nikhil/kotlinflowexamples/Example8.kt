package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.*
import java.lang.System.currentTimeMillis


/**
 * Coroutine cancellation is cooperative
 */

/**
 * it continues to print "I'm sleeping" even after cancellation until the job completes by itself after five iterations.
 */
/*
fun main() = runBlocking {
    val startTime = currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (i < 5) { // computation loop, just wastes CPU
            // print a message twice a second
            if (currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}*/

/**
 * Replace while (i < 5) in the previous example with while (isActive).
 *
 * isActive is an extension property available inside the coroutine via the CoroutineScope object.
 */
/*
fun main() = runBlocking {
    val startTime = currentTimeMillis()
    val job = launch(Dispatchers.Default) {
        var nextPrintTime = startTime
        var i = 0
        while (isActive) { // cancellable computation loop
            // print a message twice a second
            if (currentTimeMillis() >= nextPrintTime) {
                println("job: I'm sleeping ${i++} ...")
                nextPrintTime += 500L
            }
        }
    }
    delay(1300L) // delay a bit
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // cancels the job and waits for its completion
    println("main: Now I can quit.")
}*/
