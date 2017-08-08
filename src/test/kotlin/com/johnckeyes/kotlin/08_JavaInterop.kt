package com.johnckeyes.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class JavaInterop {

    /**
     * Kotlin has 100% interoperability with Java. Notice that, the Java
     * conventional getBlah() and setBlah() methods are transformed into
     * .blah and .blah = value.
     */
    @Test
    fun `using a Java class`() {
        val pojo = BoringOldPojo("bleh")
        assertThat(pojo.blah).isEqualTo("bleh")

        pojo.blah = "meh"
        assertThat(pojo.blah).isEqualTo("meh")
    }
}