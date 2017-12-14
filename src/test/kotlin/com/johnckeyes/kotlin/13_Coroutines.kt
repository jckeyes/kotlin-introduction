@file:Suppress("EXPERIMENTAL_FEATURE_WARNING")

package com.johnckeyes.kotlin

import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.junit.Test
import kotlin.concurrent.thread

class Coroutines {


    @Test(expected = OutOfMemoryError::class)
    fun launchALotOfThreads() {
        val jobs = List(100_000) {
            thread {
                Thread.sleep(1000L)
                print(".")
            }
        }
        jobs.forEach { it.join() }
    }

    @Test
    fun launchALotOfCoroutines() = runBlocking {
        val jobs = List(100_000) {
            launch {
                delay(1000L)
                print(".")
            }
        }
        jobs.forEach { it.join() }
    }
}