package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Collections {

    @Test
    fun `immutable list`() {
        val list: List<Int> = listOf(1, 2, 3)

        assertThat(list).hasSize(3)
    }

    @Test
    fun `mutable list`() {
        val list: MutableList<Int> = mutableListOf(1, 2, 3)
        list.add(4)

        assertThat(list).hasSize(4)
    }

    @Test
    fun `map reduce`() {
        val list = listOf("a", "big", "fish")
        val sentence = list.map { "$it " }.reduce { a, b -> a + b }.trim()

        assertThat(sentence).isEqualTo("a big fish")
    }

    @Test
    fun `other collections`() {
        val set = setOf(1, 2, 3)
        assertThat(set).hasSize(3)

        val map = mutableMapOf("one" to 1, "two" to 2, "three" to 3)
        assertThat(map["one"]).isEqualTo(1)
    }
}