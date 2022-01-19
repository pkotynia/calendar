package com.polodex.calendar

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux
import java.time.LocalDateTime

interface TimeSlotQueryRepository : R2dbcRepository<TimeSlotDTO, String> {

    @Query("SELECT u.name as user_name,\n" +
            "    s.start_time as time_slot_start_time,\n" +
            "    s.end_time as time_slot_end_time\n" +
            "FROM time_slot s\n" +
            "LEFT JOIN calendar_user u on s.user_id = u.id\n" +
            "WHERE s.calendar_id = :calendarId")
    fun findByCalendarId(calendarId: Int): Flux<TimeSlotDTO>
}

data class TimeSlotDTO(val userName:String, val timeSlotStartTime: LocalDateTime, val timeSlotEndTime: LocalDateTime)