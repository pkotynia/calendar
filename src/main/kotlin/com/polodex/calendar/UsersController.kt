package com.polodex.calendar

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono

@RestController
@RequestMapping("/users")
class UsersController(val usersRepository: UsersRepository) {

    fun addUser(request: ServerRequest) = request.bodyToMono<User>()
        .flatMap {
            ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                    BodyInserters.fromProducer(
                        usersRepository.save(it),
                        User::class.java
                    )
                )
        }
}