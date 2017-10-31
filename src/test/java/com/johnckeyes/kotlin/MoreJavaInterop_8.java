package com.johnckeyes.kotlin;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoreJavaInterop_8 {
    @Test
    public void canUseKotlinFromJava() throws Exception {
        ExcitingNewPoko poko = new ExcitingNewPoko("awesome");

        assertThat(poko.getYay()).isEqualTo("awesome");
    }
}
