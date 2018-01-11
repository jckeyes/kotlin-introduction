@file:Suppress("ConstantConditionIf", "MemberVisibilityCanPrivate")

package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ControlFlow {

    /**
     * Conditional expression (in this case an if) return a value. The value returned
     * by the statement is the result of the whichever block of code was execute.
     * This simple if/else would be expressed as a ternary operator is other languages.
     */
    @Test
    fun `conditional assignment`() {
        val itIsTrue = true
        val goesWithMac = if (itIsTrue) "cheese" else "not cheese"

        assertThat(goesWithMac).isEqualTo("cheese")
    }


    /**
     * One benefit of conditional assignments is they can be much more complex without
     * sacrificing readability.
     */
    @Test
    fun `complex conditional assignment`() {
        val itIsTrue = true
        val itIsFalse = false
        val whatsForDinner = if (itIsFalse) {
            "some food"
        } else if (itIsFalse || itIsTrue) {
            "all the food"
        } else {
            "no food"
        }

        assertThat(whatsForDinner).isEqualTo("all the food")
    }


    /**
     * When expressions are similar to switch statements in other languages
     * As with other control statements in Kotlin, they return a value.
     */
    @Test
    fun `when assignment`() {
        val num = 5
        val factAboutTacos = when (num) {
            1 -> "they are pointless"
            2 -> "they are inedible"
            else -> {
                val yodaSpeak = "magic they are"
                val words = yodaSpeak.split(" ")
                "${words[1]} ${words[2]} ${words[0]}"
            }
        }

        assertThat(factAboutTacos).isEqualTo("they are magic")
    }


    /**
     * Combining control assignment with inline function bodies makes for
     * very simple and expressive code.
     */
    fun whatMealIsIt(time: Int) = when {
        time < 12 -> "breakfast"
        time < 18 -> "lunch"
        else -> "dinner"
    }

    @Test
    fun `single line expressive function`() {
        val meal = whatMealIsIt(14)
        assertThat(meal).isEqualTo("lunch")
    }
}