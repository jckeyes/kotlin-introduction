package com.johnckeyes.kotlinkoans

import org.junit.Assert.assertEquals
import org.junit.Test

class Thing {
    fun value() = "something"
}

class ComplexThing(adjective: String) {
    val name = "a $adjective thing"
}

open class BaseThing() {
    fun value() = "base"
}

class InheritedThing: BaseThing() {
}

class Classes {

    @Test
    fun thing() {
        val thing = Thing()
        assertEquals(thing.value(), "something")
    }

    @Test
    fun complexThing() {
        val bigThing = ComplexThing("big")
        val smallThing = ComplexThing("small")

        assertEquals(bigThing.name, "a big thing")
        assertEquals(smallThing.name, "a small thing")
    }

    @Test
    fun inheritedThing() {
        val baseThing = BaseThing()
        val inheritedThing = InheritedThing()

        assertEquals(baseThing.value(), inheritedThing.value())
    }
}