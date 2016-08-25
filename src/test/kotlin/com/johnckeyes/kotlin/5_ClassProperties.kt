package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class GettersAndSetters() {

    var _name: String = ""

    var name: String
        get() = _name
        set(value) {
            _name = value
        }

    val description: String
        get() = "A thing named $_name"
}

class InlineProperty(val name: String, val size: Int)

data class DataClass(val name: String, val size: Int)

class ClassProperties {

    @Test
    fun inlineProperties() {
        val thing = InlineProperty("thing", 100)
        assertThat(thing.name).isEqualTo("thing")
        assertThat(thing.size).isEqualTo(100)

        val thing2 = InlineProperty(size = 200, name = "thing2")
        assertThat(thing2.name).isEqualTo("thing2")
        assertThat(thing2.size).isEqualTo(200)
    }

    @Test
    fun gettersAndSetters() {
        val thing = GettersAndSetters()

        thing.name = "Jeff"

        assertThat(thing.name).isEqualTo("Jeff")
        assertThat(thing.description).isEqualTo("A thing named Jeff")
    }

    @Test
    fun dataClass() {
        val nonDataClass1 = InlineProperty("a", 1)
        val nonDataClass2 = InlineProperty("a", 1)
        assertThat(nonDataClass1).isNotEqualTo(nonDataClass2)

        val dataClass1 = DataClass("b", 2)
        val dataClass2 = DataClass("b", 2)
        assertThat(dataClass1).isEqualTo(dataClass2)

        println(nonDataClass1)
        println(dataClass1)
    }
}