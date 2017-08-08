package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.*
import org.junit.Test

class HighOrderFunctions {

    /**
     * Like many languages, Kotlin has support for anonymous functions,
     * also known as Lambdas.
     */
    var addingLambda = { x: Int, y: Int -> x + y }
    var subtractingLambda = { x: Int, y: Int -> x - y }

    /**
     * Lambdas can be used as parameters in other functions, which are
     * referred to as Higher Order Functions.
     */
    fun executeOperation(method: (Int, Int) -> Int): Int {
        return method(2, 1)
    }


    @Test
    fun `executing lambda via higher order functions`() {
        val added = executeOperation(addingLambda)
        assertThat(added).isEqualTo(3)

        val subtracted = executeOperation(subtractingLambda)
        assertThat(subtracted).isEqualTo(1)

        val everything = executeOperation { a, b -> a + b + (a * b) + (a - b) }
        assertThat(everything).isEqualTo(6)
    }

}