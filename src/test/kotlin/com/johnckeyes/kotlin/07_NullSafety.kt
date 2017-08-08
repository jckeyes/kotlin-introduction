package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class NullSafety {

    /**
     * For nullable types, you can use the safe call operator
     * to call methods and access properties on a potentially null
     * object. If the object is null, the resulting expression will
     * return null.
     */
    @Test
    fun `safe call operator`() {
        val nothing: List<String>? = null
        val firstItem = nothing?.first()

        assertThat(firstItem).isNull()
    }




    /**
     * The Elvis operator will provide a default value
     * to be used if the preceding expression results in a null
     * value.
     *
     * It is the same as doing:
     * var firstItem = "N/A"
     * if (nothing != null) {
     *      firstItem = nothing.first()
     * }
     */
    @Test
    fun `the Elvis operator`() {
        val nothing: List<String>? = null
        val firstItem = nothing?.first() ?: "N/A"

        assertThat(firstItem).isEqualTo("N/A")
    }




    /**
     * If you have a nullable type, you can use the !! operator
     * to return a non-null value.
     *
     * Be Warned: the !! operator essentially undoes the null safety
     * provided Kotlin. If you access methods, properties on a null
     * object an NPE will be thrown.
     */
    @Test
    fun `successful unwrapping`() {
        val nothing: List<String>? = listOf("thing")
        val length = nothing!!.first()

        assertThat(length).isEqualTo("thing")
    }

    @Test(expected = KotlinNullPointerException::class)
    fun `unsuccessful unwrapping`() {
        val nothing: List<String>? = null
        val length = nothing!!.first()
    }




    /**
     * The Kotlin compiler is able to recognize when you done a null
     * check before accessing a nullable variable. In this case, it is no
     * longer required that you access it with a ? or !! operator.
     *
     * Kotlin calls this "Smart Cast"
     */
    @Test
    fun `compiler assisted unwrapping`() {
        val nothing: List<String>? = listOf("thing")
        var firstItem: String? = null

        if (nothing != null) {
            firstItem = nothing.first()
        }

        assertThat(firstItem).isEqualTo("thing")
    }




    /**
     * It's important to note that lateinit variables should
     * not be treated like nullable variables. Even performing a null
     * check against an uninitialized variable will result in an
     * Exception.
     *
     * These are best left for your DI frameworks.
     */
    lateinit var landMine: String

    @Test(expected = UninitializedPropertyAccessException::class)
    fun `uninitialized property`() {
        if (landMine == null) {
            println("I'm Safe!")
        }
    }
}