package com.polodex.calendar

import org.springframework.data.annotation.Id
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono
import java.util.*

@RestController
@RequestMapping("/calendars")
class CalendarController(val calendarRepository: CalendarRepository) {

    fun getCalendarById(request: ServerRequest) = ServerResponse
        .ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(
            BodyInserters.fromProducer(
                calendarRepository.findCalendarById(
                    request
                        .queryParam("id")
                        .orElse("").toInt()
                ), Calendar::class.java
            )
        )

    fun createEmptyCalendar(request: ServerRequest) = request.bodyToMono<Calendar>()
        .flatMap {
            ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(
                    BodyInserters.fromProducer(
                        calendarRepository.save(Calendar(null, it.userId, UUID.randomUUID().toString(), it.name)),
                        Calendar::class.java
                    )
                )
        }

}

