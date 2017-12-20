package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class FunctionDeclarations {

    /**
     * methods are declared with the 'fun' keyword.
     *
     * Java:
     * public void voidMethod() { ... }
     */
    fun voidMethod() {
        assertThat(true).isTrue()
    }



    /**
     * Similar to variables, parameters types are declared after the param name
     *
     * Java:
     * public void voidMethod(String param) { ... }
     */
    fun voidMethod(param: String) {
        assertThat(param).isNotNull()
    }

    /**
     * You can include spaces in method names if you quote them with backticks
     * This is very nice, for in tests.
     */
    @Test
    fun `call void method`() {
        voidMethod()
        voidMethod("foo")
    }




    /**
     * Similar to variables, method types are declared after the method name
     *
     * Java:
     * public String stringMethod() { ... }
     */
    fun stringMethod(): String {
        return "something"
    }

    @Test
    fun `call String method`() {
        val result = stringMethod()
        assertThat(result).isEqualTo("something")
    }




    /**
     * Parameters can be give default values.
     *
     * Java:
     * public String defaultParameters(String param) { ... }
     * public String defaultParameters() { return defaultParameters("something"); }
     */
    fun defaultParameters(param: String = "something"): String {
        return param
    }

    @Test
    fun `call default parameters`() {
        val one = defaultParameters()
        assertThat(one).isEqualTo("something")

        val two = defaultParameters("something else")
        assertThat(two).isEqualTo("something else")
    }




    /**
     * When a method is called, parameters can be specified by name
     * allowing them to be provided in any order (see test)
     *
     * Java: ¯\_(ツ)_/¯
     */
    fun namedParameters(first: String, second: String): String {
        return first + second
    }

    @Test
    fun `call named parameters`() {
        val one = namedParameters("A", "B")
        assertThat(one).isEqualTo("AB")

        val two = namedParameters(first = "A", second = "B")
        assertThat(two).isEqualTo("AB")

        val three = namedParameters(second = "B", first = "A")
        assertThat(three).isEqualTo("AB")
    }




    /**
     * Method bodies can skip the braces if they are a single expression
     *
     * * Java: ¯\_(ツ)_/¯
     */
    fun singleExpressionMethod(vararg list: Int) = list.map { it + 10 }.sum()

    @Test
    fun `call single expression method`() {
        val result = singleExpressionMethod(1, 2, 3)
        assertThat(result).isEqualTo(36)
    }




    /**
     * Functions can have other functions nested inside them to encapsulate logic
     * Inner functions have access to variables from the outer function
     *
     * * Java: ¯\_(ツ)_/¯
     */
    fun outerFunction(message: String) : String{
        fun innerFunction(punctuation: Char): String {
            return "$message$punctuation"
        }
        return "${innerFunction('?')} ${innerFunction('!')}"
    }

    @Test
    fun `call inner function`() {
        val result = outerFunction("Kotlin")
        assertThat(result).isEqualTo("Kotlin? Kotlin!")
    }




    /**
     * Unlike Java (any many other languages) Kotlin classes do not have static methods.
     * Instead, you can use package level functions, which exist outside of a class.
     * There are ways to call a "static" method on a class
     * (see https://kotlinlang.org/docs/reference/object-declarations.html). But this is
     * not the preferred way.
     *
     * Java:
     * public static String packageLevelFunction() { ... }
     */
    @Test
    fun `call package level function`() {
        val result = packageLevelFunction();
        assertThat(result).isEqualTo("I'm Free!")
    }
}


fun packageLevelFunction(): String {
    return "I'm Free!"
}