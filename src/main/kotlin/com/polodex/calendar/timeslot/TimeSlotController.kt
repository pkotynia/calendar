package com.polodex.calendar.timeslot

import com.polodex.calendar.TimeSlot
import com.polodex.calendar.TimeSlotQueryRepository
import com.polodex.calendar.TimeSlotRepository
import com.polodex.calendar.TimeSlotDTO
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.BodyInserters
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.bodyToMono

@RestController
@RequestMapping("/timeslots")
class TimeSlotController(val timeSlotQuerryRepository: TimeSlotQueryRepository, val timeSlotRepository: TimeSlotRepository) {

    fun createTimeSlot(request: ServerRequest) =
        request.bodyToMono<TimeSlot>()
            .flatMap {
                ServerResponse
                    .ok()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(
                        BodyInserters.fromProducer(
                            timeSlotRepository.save(it),
                            TimeSlot::class.java
                        )
                    )
            }

    fun getTimeSlotsByCalendarId(request: ServerRequest) =
        ServerResponse
            .ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(
                BodyInserters.fromProducer(
                    timeSlotQuerryRepository.findByCalendarId(
                        request
                            .queryParam("calendarId")
                            .orElse("").toInt()
                    ),
                    TimeSlotDTO::class.java
                )
            )
}