package com.polodex.calendar

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunctions

@Configuration(proxyBeanMethods = false)
class CalendarRouter {

    @Bean
    fun getUserByIdRoute(calendarHandler: CalendarController) = RouterFunctions
        .route(
            GET("/calendars")
                .and(accept(MediaType.APPLICATION_JSON))
                .and(queryParam("id") { true })
        ) { request -> calendarHandler.getCalendarById(request) }
        .andRoute(
            POST("/calendars")
                .and(accept(MediaType.APPLICATION_JSON))
        ) { request -> calendarHandler.createEmptyCalendar(request) }

}