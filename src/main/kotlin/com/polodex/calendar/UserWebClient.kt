package com.polodex.calendar

import org.springframework.web.reactive.function.client.WebClient

val client = WebClient.create("http://localhost:8080")

fun main(args: Array<String>) {
    client.get().uri("calendars?id=1")
        .retrieve()
        .bodyToFlux(Calendar::class.java)
        .subscribe { println("find me $it") }

    //welcome to nonblocking world :)
    Thread.sleep(5000)

    println("finished")
}