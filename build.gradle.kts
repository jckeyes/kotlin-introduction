import org.gradle.api.internal.tasks.testing.JULRedirector
import org.gradle.api.plugins.ExtensionAware

import org.junit.platform.gradle.plugin.FiltersExtension
import org.junit.platform.gradle.plugin.EnginesExtension
import org.junit.platform.gradle.plugin.JUnitPlatformExtension

import org.gradle.api.tasks.testing.Test
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

buildscript {
    dependencies {
        classpath("org.junit.platform:junit-platform-gradle-plugin:1.0.0")
    }
}

plugins {
    java
    kotlin("jvm") version "1.2.10"
}

repositories {
    mavenCentral()
}

dependencies {
    compile(kotlin("stdlib"))
    compile(kotlin("reflect"))
    compile("org.jetbrains.kotlinx:kotlinx-coroutines-core:0.20")

    testCompile("junit:junit:4.12")
    testCompile("org.assertj:assertj-core:3.5.2")
}

//(tasks["test"] as Test).environment.put("is_ci", "TRUE")

tasks {
    "test"(Test::class) {
        environment.put("is_ci", properties["is_ci"] ?: "FALSE")
    }
}