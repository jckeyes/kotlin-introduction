package com.johnckeyes.kotlinkoans

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

/**
 * methods are declared with the 'fun' keyword.
 */
fun voidMethod() {
    assert(true)
}

/**
 * Similar to variables, parameters types are declared after the param name
 */
fun voidMethod(param: String) {
    assert(true)
}

/**
 * Similar to variables, method types are declared after the method name
 */
fun stringMethod(): String {
    return "something"
}

/**
 * Parameters can be give default values.
 */
fun defaultParameters(param: String = "something"): String {
    return param
}

/**
 * When a method is called, parameters can be specified by name
 * allowing them to be provided in any order (see test)
 */
fun namedParameters(first: String, second: String): String {
    return first + second
}

/**
 * Method bodies can be written inline if they are a single expression
 */
fun inlineMethod(vararg list: Int) = list.map { it + 10 }.sum()

class FunctionDeclarations {

    @Test
    fun callVoidMethod() {
        voidMethod()
        voidMethod("foo")
    }

    @Test
    fun callStringMethod() {
        val result = stringMethod()
        assertThat(result).isEqualTo("something")
    }

    @Test
    fun callDefaultParameters() {
        val one = defaultParameters()
        assertThat(one).isEqualTo("something")

        val two = defaultParameters("something else")
        assertThat(two).isEqualTo("something else")
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

    @Test
    fun callInlineMethod() {
        val result = inlineMethod(1, 2, 3)
        assertThat(result).isEqualTo(36)
    }
}