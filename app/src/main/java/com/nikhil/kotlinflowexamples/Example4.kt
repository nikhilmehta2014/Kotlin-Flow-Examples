package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

/**
 * Flow Builders
 */
@ExperimentalCoroutinesApi
fun main() = runBlocking<Unit> {

    //1
    /**
     * [flowOf]
     */
    flowOf(5, 1, 9, 7)
        .collect {
            println(it.toString())
        }

    //2
    /**
     * [asFlow]
     */
    (2..6).asFlow()
        .collect {
            println(it.toString())
        }

    //3
    /**
     * [flow]
     */
    flow {
        (0..10).forEach {
            emit(it)
        }
    }
        .collect {
            println(it.toString())
        }

    //4
    /**
     * [channelFlow]
     */
    channelFlow {
        (0..10).forEach {
            send(it)
        }
    }
        .collect {
            println(it.toString())
        }
}