@file:Suppress("EXPERIMENTAL_FEATURE_WARNING", "MemberVisibilityCanPrivate")

package com.johnckeyes.kotlin

import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.data.Percentage
import org.junit.Assume
import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import java.lang.Thread.sleep
import java.util.*
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

class Coroutines {

    /***
     * Have you ever tried to create 100,000 threads?
     *
     * SPOILER ALERT! It doesn't end well.
     */
    @Test(expected = OutOfMemoryError::class)
    fun launchALotOfThreads() {
        Assume.assumeFalse("This test can not run on TravisCI", runningOnCI)

        (0..100000).map {
            thread(name = "swarm") {
                sleep(1000)
                print("ಠ_ಠ ")
            }
        }.forEach { it.join() }
    }

    /***
     * Coroutines, depending on the circumstance, are not always dispatched
     * to a brand new thread. This means that you can create 100,000 coroutines
     * with now problem
     */
    @Test
    fun launchALotOfCoroutines() = runBlocking {
        (0..100000).map {
            launch {
                delay(1000L)
                print("ʕ•ᴥ•ʔ ")
            }
        }.forEach { it.join() }
    }




    private suspend fun getRandomFood(): String {
        delay(1000)
        val foods = listOf("Tacos", "Sushi", "Pizza", "Cheese",
                "Biscuits", "Gyros", "Bacon", "Potatoes")
        val idx = Random().nextInt(foods.size)
        return foods[idx]
    }

    @Test
    fun sequenceInvocation() {
        runBlocking {
            val executionTime = measureTimeMillis {
                val one = getRandomFood()
                val two = getRandomFood()
                println("I like to eat $one and $two")
            }
            assertThat(executionTime).isCloseTo(2000L, allowedError)
        }

    }

    @Test
    fun asyncInvocation() {
        runBlocking {
            val executionTime = measureTimeMillis {
                val one = async { getRandomFood() }
                val two = async { getRandomFood() }
                println("I like to eat ${one.await()} and ${two.await()}.")
            }
            assertThat(executionTime).isCloseTo(1000L, allowedError)
        }
    }

    /***
     * Even though [launchALotOfThreads] fails, it still leaves a LOT
     * of active threads in its wake. If this is the case, we should
     * allow them to finish before we continue on.
     */
    @Before
    fun setup() {
        if (Thread.activeCount() > 100) {
            println("High thread count detected. Garbage output to follow.")
            Thread.getAllStackTraces().keys.filter {
                it.name.contains("swarm")
            }.forEach { it.join() }
            println("\nThread state is now normal!\n\n")
        }
    }

    private val allowedError = Percentage.withPercentage(5.0)
    private val runningOnCI = System.getenv("is_ci")?.toUpperCase() == "TRUE"
}