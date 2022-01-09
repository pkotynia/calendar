package com.polodex.calendar

import org.springframework.data.annotation.Id
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.relational.core.mapping.Table
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface CalendarRepository : R2dbcRepository<Calendar, String> {

    @Query("select * from calendar c where id = :id")
    fun findCalendarById(id: Int): Mono<Calendar>
}

@Table("calendar")
data class Calendar(@Id val id:Int?, val userId:Int, val uuid:String?, val name: String)


