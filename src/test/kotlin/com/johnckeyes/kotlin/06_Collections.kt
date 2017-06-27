package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Collections {

    /**
     * Collections come in two flavors: Mutable and Immutable
     *
     * Immutable collections can not be modified in any way.
     */
    @Test
    fun `immutable list`() {
        val list: List<Int> = listOf(1, 2, 3)

        assertThat(list).hasSize(3)
    }



    /**
     * Mutable collections, on the other hand, can be modified in much the same
     * way Java collections can.
     */
    @Test
    fun `mutable list`() {
        val list: MutableList<Int> = mutableListOf(1, 2, 3)
        list.add(4)
        list.add(5)
        list.removeAt(0)

        assertThat(list).hasSize(4)
    }



    /**
     * Collections have a number of "modern" utility functions.
     *
     * Here is an example of a Map/Reduce
     */
    @Test
    fun `map reduce`() {
        val list = listOf("a", "big", "fish")
        val sentence = list.map { "$it " }.reduce { a, b -> a + b }.trim()

        assertThat(sentence).isEqualTo("a big fish")
    }



    /**
     * Sets and Maps both have mutable and immutable implementations.
     */
    @Test
    fun `other collections`() {
        val set = setOf(1, 2, 3)
        assertThat(set).hasSize(3)

        val map = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
        assertThat(map["one"]).isEqualTo(1)
    }
}