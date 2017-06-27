package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class DestructuringDeclarations {

    /**
     * Using the componentN operator functions, classes can take advantage
     * of destructuring declarations
     */
    class Person(val firstName: String, val lastName: String) {
        operator fun component1() = firstName
        operator fun component2() = lastName
    }

    @Test
    fun `destructuring declaration`() {
        val person = Person(firstName = "John", lastName = "Keyes")
        val (first, last) = person

        assertThat(first).isEqualTo(person.firstName)
        assertThat(last).isEqualTo(person.lastName)
    }




    /**
     * Data classes have component operators out of the box.
     * Maps can be destructured in a key/value pair.
     * Also, you can use destructuring declarations in a loop.
     */
    data class Food(val name: String, val deliciousness: Int)

    @Test
    fun `destructuring declaration on loop`() {
        var idx = 0
        val people = listOf(
                Food(name = "Tacos", deliciousness = 93820),
                Food(name = "Sushi", deliciousness = 93819)
        )

        for ((name, rating) in people) {
            assertThat(name).isEqualTo(people[idx].name)
            assertThat(rating).isEqualTo(people[idx].deliciousness)
            idx++
        }
    }
}