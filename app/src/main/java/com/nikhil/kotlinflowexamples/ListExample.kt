package com.nikhil.kotlinflowexamples

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

private suspend fun getValues(): List<Int>{
    delay(1000)
    return listOf(1, 2, 3, 4, 5)
}

private fun processValues(){
    runBlocking {
        val values = getValues()
        for (value in values){
            println(value)
        }
    }
}

/**
 * This will print values from 1 to 5 in one go.
 */
fun main(){
    processValues()
}