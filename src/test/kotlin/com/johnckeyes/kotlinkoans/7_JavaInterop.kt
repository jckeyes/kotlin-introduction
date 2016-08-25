package com.johnckeyes.kotlinkoans

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class JavaInterop {

    @Test
    fun usingAJavaClass() {
        val pojo = BoringOldPojo("bleh")
        assertThat(pojo.blah).isEqualTo("bleh")

        pojo.blah = "meh"
        assertThat(pojo.blah).isEqualTo("meh")
    }
}