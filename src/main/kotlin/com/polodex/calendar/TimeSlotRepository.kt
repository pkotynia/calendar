package com.polodex.calendar

import org.springframework.data.annotation.Id
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.relational.core.mapping.Table
import java.time.LocalDateTime

interface TimeSlotRepository: R2dbcRepository<TimeSlot, String>

@Table("time_slot")
data class TimeSlot(@Id val id:Int?, val userId:Int, val calendarId:Int, val startTime:LocalDateTime, val endTime:LocalDateTime)
