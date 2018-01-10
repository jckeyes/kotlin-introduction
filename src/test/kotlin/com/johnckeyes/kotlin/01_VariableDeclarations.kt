@file:Suppress("unused", "MemberVisibilityCanPrivate")

package com.johnckeyes.kotlin

import java.util.*


class VariableDeclaration {

    /**
     * Using the keyword 'var' declares a variable as mutable. It can be changed
     * at any point. It can not be null, however.
     *
     * Java: String mutableVariable = "yep";
     */
    var mutableVariable: String = "yep"


    /**
     * Using the keyword 'val' declares a variable as immutable. Attempting
     * to change the value later will result in a compilation error.
     *
     * Java: final String immutableString = "nope";
     */
    val immutableVariable: String = "nope"


    /**
     * The type declaration at the end of a variable is not required if the compiler
     * can infer the type
     *
     * Java: Good Luck
     */
    val impliedTyped = 100


    /**
     * Variables are not nullable by default. To make a variable nullable a ? is added to the
     * type declaration. Similar to swift
     *
     * Java: String nullValue;
     */
    val nullValue: String? = null


    /**
     * Values are required for all variables (even null values) in Kotlin. The only exception is when
     * a variable is marked as 'lateinit'. Perhaps the best use for this is IOC frameworks, like Spring.
     * Lateinit value must be declared as 'var'.
     *
     * Java: Date lateDate;
     */
    lateinit var lateDate: Date


    /**
     * Kotlin supports the boxing/unboxing of primitives by making the value optional (?)
     *
     * Java:
     * int unboxedPrimitive = 200;
     * Integer boxedPrimitive;
     */
    val unboxedPrimitive: Int = 200
    val boxedPrimitive: Int? = null


    /**
     * Kotlin string interpolation
     *
     * Java:
     * String.format("hello %s!", "Bob")
     */
    val name = "Bob"
    val greeting = "hello $name!"
}