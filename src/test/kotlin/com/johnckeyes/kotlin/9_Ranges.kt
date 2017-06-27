package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.*
import org.junit.Test

class Ranges {

    /**
     * Ranges can be used in conjunction with in and !in
     * operators to test values.
     *
     * Java: 10 >= 1 && 10 <= 20
     */
    @Test
    fun `check if value is in range`() {
        val numberIsIn = 10 in 1..20
        assertThat(numberIsIn).isTrue()

        val numberIsNotIn = 500 !in 5..50
        assertThat(numberIsNotIn).isTrue()

        val min = 10
        val max = 100
        val range = min..max
        val target = 4
        val targetIsIn = target in range
        assertThat(targetIsIn).isFalse()
    }




    /**
     * You can also iterate over ranges.
     *
     * There are a number of utilities, like downTo and step,
     * that make ranges even more useful.
     */
    @Test
    fun `range loops and steps`() {
        var result = ""
        for (i in 1..5) result += i
        assertThat(result).isEqualTo("12345")


        var stepResult = ""
        for (i in 8 downTo 0 step 2) stepResult += i
        assertThat(stepResult).isEqualTo("86420")
    }
}