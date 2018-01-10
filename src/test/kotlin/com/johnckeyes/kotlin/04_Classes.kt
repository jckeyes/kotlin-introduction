@file:Suppress("RedundantExplicitType", "unused")

package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Classes {

    /**
     * Basic Kotlin class declarations are similar to Java. Methods and properties
     * are public by default. Also, as you may have noticed, Kotlin supports inner
     * classes similar to Java.
     */
    class Thing {
        fun value() = "something"
        private fun privateValue() = "secret"
    }

    @Test
    fun thing() {
        val thing = Thing()
        assertThat(thing.value()).isEqualTo("something")
    }



    /**
     * A constructor can be uspecified in the class declaration. Similar to Java, the resulting
     * class will not have an empty constructor.
     */
    class ComplexThing(adjective: String) {

        /**
         * constructor arguments can be use when initializing properties of the class. They are
         * not available for use within methods. If more complicated or non assigment logic is required,
         * an 'init' block can be used.
         */
        val name = "a $adjective thing"

        /**
         * Additional convenience constructors can be added in the body of the classu
         */
        constructor(adjectiveOne: String, adjectiveTwo: String)
        : this("$adjectiveOne $adjectiveTwo")
    }

    @Test
    fun `complex thing`() {
        val bigThing = ComplexThing("big")
        assertThat(bigThing.name).isEqualTo("a big thing")

        val smallThing = ComplexThing("small")
        assertThat(smallThing.name).isEqualTo("a small thing")

        val veryTinyThing = ComplexThing("very", "tiny")
        assertThat(veryTinyThing.name).isEqualTo("a very tiny thing")
    }




    /**
     * Kotlin classes are closed (think final in Java) by primary. If you want to extend a class, it must
     * be explicitly marked as open. As classes openness is not inherited by it's methods. Methods of an open
     * class that are intended to be overridden must also be marked as open.
     */
    open class Sandwich(val contents: String) {
        open fun describe(): String {
            return "Mmmm, a $contents sandwich"
        }
    }

    /**
     * A subclass must use the primary constructor of it's parent
     */
    class ClubSandwich(contents: String, val layers: Int) : Sandwich(contents) {
        override fun describe(): String {
            return "Mmmm, a $layers layer $contents sandwich"
        }
    }

    /**
     * A subclass can change the signature of it's primary constructor, but it is still required
     * to use the it's parent primary constructor.
     */
    class PeanutButterJelly : Sandwich("peanut butter jelly") {
        override fun describe(): String {
            return "$contents time!".toUpperCase()
        }
    }

    @Test
    fun `inherited thing`() {
        var myCat: Sandwich = Sandwich("fish")
        assertThat(myCat.describe()).isEqualTo("Mmmm, a fish sandwich")

        myCat = ClubSandwich("turkey", 20)
        assertThat(myCat.describe()).isEqualTo("Mmmm, a 20 layer turkey sandwich")

        myCat = PeanutButterJelly()
        assertThat(myCat.describe()).isEqualTo("PEANUT BUTTER JELLY TIME!")
    }
}