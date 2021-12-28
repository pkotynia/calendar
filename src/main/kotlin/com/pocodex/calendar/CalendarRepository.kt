package com.pocodex.calendar

import org.springframework.data.annotation.Id
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono

@Repository
interface CalendarRepo : ReactiveCrudRepository<Calendar, String>, CalendarRepoInternal

@Component
interface CalendarRepoInternal {
//    fun getCalendarById(id:Int): Mono<Calendar>
//    fun addCalendar(calendar: Calendar): Mono<Calendar>
}

class CalendarRepositoryImpl(val r2dbcEntityTemplate: R2dbcEntityTemplate) : CalendarRepoInternal {

//    override fun getCalendarById(id: Int): Mono<Calendar> {
//        TODO("Not yet implemented")
//    }
//
//    override fun addCalendar(calendar: Calendar): Mono<Calendar> =
//        r2dbcEntityTemplate.insert(Calendar::class.java)
//            .using(calendar)
//            .defaultIfEmpty(calendar)

}

@Table("calendars")
data class Calendar(@Id val id:String, val name: String)



