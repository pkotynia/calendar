package com.polodex.calendar

import org.springframework.data.annotation.Id
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.core.insert
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.relational.core.mapping.Table
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface CalendarRepo : R2dbcRepository<Calendar, String>

@Table("calendars")
data class Calendar(@Id val id:Int?, val name: String)


