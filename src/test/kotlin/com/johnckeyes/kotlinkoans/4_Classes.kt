package com.johnckeyes.kotlinkoans

import org.junit.Assert
import org.junit.Assert.assertEquals
import org.junit.Test

class SimpleClass() {
    fun value() = "something"
}


class Classes {

    @Test
    fun simpleClass() {
        val simple = SimpleClass()
        assertEquals(simple.value(), "something")
    }
}