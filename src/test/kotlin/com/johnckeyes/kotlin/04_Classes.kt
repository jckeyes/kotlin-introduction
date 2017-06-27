package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Classes {

    /**
     * Basic Kotlin class declarations are similar to Java. Methods and properties
     * are public by default. Also, as you may have noticed, Kotlin supports inner
     * class similar to Java.
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
     * A constructor can be specified in the class declaration. Similar to Java, the resulting
     * class will not have an empty constructor.
     */
    class ComplexThing(adjective: String) {

        /**
         * Additional convenience constructors can be added in the body of the class
         */
        constructor(adjectiveOne: String, adjectiveTwo: String)
        : this("$adjectiveOne $adjectiveTwo")

        /**
         * constructor arguments can be use when initializing properties of the class. They are
         * not available for use within methods.
         */
        val name = "a $adjective thing"
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
     * Kotlin classes are closed (think final in Java) by default. If you want to extend a class, it must
     * be explicitly marked as open. As classes openness is not inherited by it's methods. Methods of an open
     * class that are intended to be overridden must also be marked as open.
     */
    open class BaseThing(v: String) {
        val value = v
    }

    /**
     * A subclass must use the default constructor of it's parent
     */
    class InheritedThing(v: String) : BaseThing(v) {
    }

    /**
     * A subclass can change the signature of it's default constructor, but it is still required
     * to use the it's parent default constructor.
     */
    class AnotherInheritedThing(): BaseThing("constant") {
    }

    @Test
    fun `inherited thing`() {
        val baseThing: BaseThing = BaseThing("base")
        val inheritedThing: BaseThing = InheritedThing("base")
        assertThat(inheritedThing.value).isEqualTo(baseThing.value)

        val anotherInheritedThing: BaseThing = AnotherInheritedThing()
        assertThat(anotherInheritedThing.value).isEqualTo("constant")
    }
}