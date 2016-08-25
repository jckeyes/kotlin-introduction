package com.johnckeyes.kotlinkoans

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class Collections {

    @Test
    fun immutableList() {
        val list: List<Int> = listOf(1, 2, 3)

        assertThat(list).hasSize(3)
    }

    @Test
    fun mutableList() {
        val list: MutableList<Int> = mutableListOf(1, 2, 3)
        list.add(4)

        assertThat(list).hasSize(4)
    }


}