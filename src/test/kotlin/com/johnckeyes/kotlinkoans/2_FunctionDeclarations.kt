package com.johnckeyes.kotlinkoans

import org.junit.Assert.assertEquals
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
fun inlineMethod(vararg list: Int) = list.reduce { a, b -> a + b }

class FunctionDeclarations {

    @Test
    fun callVoidMethod() {
        voidMethod()
        voidMethod("foo")
    }

    @Test
    fun callStringMethod() {
        assertEquals(stringMethod(), "something")
    }

    @Test
    fun callDefaultParameters() {
        assertEquals(defaultParameters(), "something")
        assertEquals(defaultParameters("something else"), "something else")
    }

    @Test
    fun callNamedParameters() {
        assertEquals(namedParameters("A", "B"), "AB")
        assertEquals(namedParameters(first = "A", second = "B"), "AB")
        assertEquals(namedParameters(second = "B", first = "A"), "AB")
    }

    @Test
    fun callInlineMethod() {
        assertEquals(inlineMethod(1, 2, 3), 6)
    }
}