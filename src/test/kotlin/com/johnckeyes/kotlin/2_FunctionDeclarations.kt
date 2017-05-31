package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FunctionDeclarations {

    /**
     * methods are declared with the 'fun' keyword.
     */
    fun voidMethod() {
        assertThat(true).isTrue()
    }




    /**
     * Similar to variables, parameters types are declared after the param name
     */
    fun voidMethod(param: String) {
        assertThat(param).isNotNull()
    }

    @Test
    fun callVoidMethod() {
        voidMethod()
        voidMethod("foo")
    }




    /**
     * Similar to variables, method types are declared after the method name
     */
    fun stringMethod(): String {
        return "something"
    }

    @Test
    fun callStringMethod() {
        val result = stringMethod()
        assertThat(result).isEqualTo("something")
    }




    /**
     * Parameters can be give default values.
     */
    fun defaultParameters(param: String = "something"): String {
        return param
    }

    @Test
    fun callDefaultParameters() {
        val one = defaultParameters()
        assertThat(one).isEqualTo("something")

        val two = defaultParameters("something else")
        assertThat(two).isEqualTo("something else")
    }




    /**
     * When a method is called, parameters can be specified by name
     * allowing them to be provided in any order (see test)
     */
    fun namedParameters(first: String, second: String): String {
        return first + second
    }

    @Test
    fun callNamedParameters() {
        val one = namedParameters("A", "B")
        assertThat(one).isEqualTo("AB")

        val two = namedParameters(first = "A", second = "B")
        assertThat(two).isEqualTo("AB")

        val three = namedParameters(second = "B", first = "A")
        assertThat(three).isEqualTo("AB")
    }




    /**
     * Method bodies can skip the braces if they are a single expression
     */
    fun singleExpressionMethod(vararg list: Int) = list.map { it + 10 }.sum()

    @Test
    fun callSingleExpressionMethod() {
        val result = singleExpressionMethod(1, 2, 3)
        assertThat(result).isEqualTo(36)
    }
}