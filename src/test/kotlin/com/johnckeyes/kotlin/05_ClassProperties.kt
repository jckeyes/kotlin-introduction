package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ClassProperties {

    /**
     * Kotlin has full support for property getters and setters.
     * Very similar to C#. No thanks to Java.
     */
    class GettersAndSetters {

        private var _name: String = ""

        var name: String
            get() = _name
            set(value) {
                _name = value
            }

        val description: String
            get() = "A thing named $_name"
    }

    @Test
    fun `getters and setters`() {
        val thing = GettersAndSetters()

        thing.name = "Jeff"

        assertThat(thing.name).isEqualTo("Jeff")
        assertThat(thing.description).isEqualTo("A thing named Jeff")
    }




    /**
     * If val or var is specified in the default constructor of a class, kotlin will
     * automatically create a class level property for it. In this case, the class
     * does not even require a body.
     */
    class InlineProperty(val name: String, val size: Int)

    @Test
    fun `inline properties`() {
        val thing = InlineProperty("thing", 100)
        assertThat(thing.name).isEqualTo("thing")
        assertThat(thing.size).isEqualTo(100)

        val thing2 = InlineProperty(size = 200, name = "thing2")
        assertThat(thing2.name).isEqualTo("thing2")
        assertThat(thing2.size).isEqualTo(200)
    }




    /**
     * If a class is marked as a data class, Kotlin will also generate equals, hashcode, toString, and
     * copy functions for that class.
     */
    data class DataClass(val name: String, val size: Int)

    @Test
    fun `data class`() {
        val nonDataClass1 = InlineProperty("a", 1)
        val nonDataClass2 = InlineProperty("a", 1)
        assertThat(nonDataClass1).isNotEqualTo(nonDataClass2)

        val dataClass1 = DataClass("b", 2)
        val dataClass2 = DataClass("b", 2)
        assertThat(dataClass1).isEqualTo(dataClass2)

        println(nonDataClass1)
        println(dataClass1)


        val dataClass3 = dataClass1.copy(size=3)

        assertThat(dataClass3).isNotEqualTo(dataClass1)
        assertThat(dataClass3.name).isEqualTo(dataClass1.name)
        assertThat(dataClass3.size).isEqualTo(3)
    }
}