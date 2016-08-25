package com.johnckeyes.kotlinkoans

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Thing {
    fun value() = "something"
}

class ComplexThing(adjective: String) {

    constructor(adjectiveOne: String, adjectiveTwo: String)
        : this("$adjectiveOne $adjectiveTwo")

    val name = "a $adjective thing"
}

open class BaseThing {
    fun value() = "base"
}

class InheritedThing : BaseThing() {
}

class Classes {

    @Test
    fun thing() {
        val thing = Thing()
        assertThat(thing.value()).isEqualTo("something")
    }

    @Test
    fun complexThing() {
        val bigThing = ComplexThing("big")
        assertThat(bigThing.name).isEqualTo("a big thing")

        val smallThing = ComplexThing("small")
        assertThat(smallThing.name).isEqualTo("a small thing")

        val veryTinyThing = ComplexThing("very", "tiny")
        assertThat(veryTinyThing.name).isEqualTo("a very tiny thing")
    }

    @Test
    fun inheritedThing() {
        val baseThing = BaseThing()
        val inheritedThing = InheritedThing()

        assertThat(inheritedThing.value()).isEqualTo(baseThing.value())
        assertThat(inheritedThing).isInstanceOf(BaseThing::class.java)
    }
}