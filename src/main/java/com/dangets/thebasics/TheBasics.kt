package com.dangets.thebasics

import java.time.LocalDate


fun getGreeting(name: String): String {
    val greeting = "Hello"
    var who = "World"
    if (name.isNotBlank())
        who = name
    return "$greeting, $who!"
}


fun main(args: Array<String>) {
    val greeting = "Hello"
    var who = "World"
    if (args.isNotEmpty())
        who = args[0]

    println("$greeting, $who")
}

fun crunch(a: Int, b: Int?) {
    // ...
}

fun munch(a: LocalDate, b: LocalDate?) {
    // ...
}


fun doodle() {
    val m = mapOf("up" to "down")
    poodle(m)
    //kaboodle(m)  // compile time error
}

fun poodle(a: Map<String, String>) {
    // a is "immutable"
    // no a.put method accessible
}

fun kaboodle(a: MutableMap<String, String>) {
    a["up"] = "down"
}


data class User(val id: Long,
                val name: String,
                val age: Int? = null)