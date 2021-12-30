package com.pocodex.calendar

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono

@RestController
@RequestMapping("/calendars")
class CalendarController(val calendarRepository: CalendarRepo) {

    fun getCalendarById(request: ServerRequest) = ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(
                                calendarRepository.findById(
                                        request
                                                .queryParam("id")
                                                .orElse("")
                                ) , Calendar::class.java
                        )
                )


    fun createEmptyCalendar(request: ServerRequest) = request.bodyToMono<Calendar>()
        .flatMap {
            ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(
                        calendarRepository.save(it),
                        Calendar::class.java))
        }

}