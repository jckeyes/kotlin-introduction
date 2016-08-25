package com.johnckeyes.kotlinkoans

import org.junit.Assert.assertEquals
import org.junit.Test

class InlineProperty(val name: String, val size: Int)

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

class ClassProperties {

    @Test
    fun inlineProperties() {
        val thing = InlineProperty("thing", 100)
        assertEquals(thing.name, "thing")
        assertEquals(thing.size, 100)

        val thing2 = InlineProperty(size = 200, name = "thing2")
        assertEquals(thing2.name, "thing2")
        assertEquals(thing2.size, 200)
    }

    @Test
    fun gettersAndSetters() {
        val thing = GettersAndSetters()

        thing.name = "Jeff"

        assertEquals(thing.name, "Jeff")
        assertEquals(thing.description, "A thing named Jeff")
    }
}