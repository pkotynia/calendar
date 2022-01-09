package com.polodex.calendar

import org.springframework.data.annotation.Id
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.relational.core.mapping.Table
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface TimeSlotRepository: R2dbcRepository<TimeSlot, String> {

    @Query("select * from time_slot c where calendar_id = :calendarId")
    fun findByCalendarId(calendarId: Int): Flux<TimeSlot>
}

@Table("time_slot")
data class TimeSlot(@Id val id:Int?,val userId:Int, val calendarId:Int)
