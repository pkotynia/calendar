package com.pocodex.calendar

import org.springframework.web.reactive.function.client.WebClient

val client = WebClient.create("http://localhost:8080")

fun main(args: Array<String>) {
    println("I am here")
    client.get().uri("hi/")
        .retrieve()
        .bodyToFlux(Calendar::class.java)
        .subscribe { println("find me $it") }

    Thread.sleep(5000)

    println("finished")
}