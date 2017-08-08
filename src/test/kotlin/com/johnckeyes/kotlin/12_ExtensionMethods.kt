package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test



class ExtensionMethods {

    /**
     *  Similar to other languages, Kotlin allows you to extend classes without
     *  having to use inheritance.
     */
    fun String.withFeeling(): String {
        return "${this.toUpperCase()}!!!"
    }

    @Test
    fun `basic extension method`() {
        assertThat("tacos".withFeeling()).isEqualTo("TACOS!!!")
    }



    /**
     * Kotlin supports both extension methods and extension properties.
     * You are not able to access any private methods, variables within
     * an extension method.
     */
    data class Taco(val filling: String, private val weight: Int)

    val Taco.description: String
        get() = "Mmm, ${this.filling} tacos"


    @Test
    fun `extend closed class`() {
        val fido = Taco("fish", 10)
        assertThat(fido.description).isEqualTo("Mmm, fish tacos")
    }
}