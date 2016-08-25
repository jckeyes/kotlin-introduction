package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ControlFlow {

    /**
     * Conditional expression (in this case an if) return a value. This means that they
     * can be used to assign variables
     */
    @Test
    fun conditionalAssignment() {
        val itIsTrue = true
        val value = if (itIsTrue) 100 else 200

        assertThat(value).isEqualTo(100)
    }




    /**
     * Conditional assignments can be as complex as traditional if statements
     */
    @Test
    fun complexConditionalAssignment() {
        val itIsTrue = true
        val itIsFalse = false
        val value = if (itIsFalse) {
            100
        } else if (itIsFalse || itIsTrue) {
            200
        } else {
            300
        }

        assertThat(value).isEqualTo(200)
    }




    /**
     * When expressions are similar to switch statements in other languages
     */
    @Test
    fun whenExpression() {
        val num = 5
        var result = ""

        when (num) {
            1 -> result = "a"
            5 -> result = "b"
            else -> result = "c"
        }

        assertThat(result).isEqualTo("b")
    }




    /**
     * Similar to ifs, whens can be used in assignments
     */
    @Test
    fun whenAssignment() {
        val num = 5
        val result = when (num) {
            1 -> "a"
            5 -> "b"
            else -> "c"
        }

        assertThat(result).isEqualTo("b")
    }
}