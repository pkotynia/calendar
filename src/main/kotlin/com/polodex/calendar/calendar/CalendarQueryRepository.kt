package com.polodex.calendar.calendar

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import reactor.core.publisher.Flux

interface CalendarQueryRepository: R2dbcRepository<CalendarDTO, String> {

    @Query("SELECT u.name as owner_name,\n" +
            "    c.uuid as calendar_uuid,\n" +
            "    c.name as calendar_name\n" +
            "FROM calendar c\n" +
            "LEFT JOIN calendar_user u on c.user_id = u.id\n" +
            "WHERE c.user_id = :calendarId")
    fun findCalendarById(calendarId:Int): Flux<CalendarDTO>
}

data class CalendarDTO(val ownerName:String, val calendarUuid:String, val calendarName: String)