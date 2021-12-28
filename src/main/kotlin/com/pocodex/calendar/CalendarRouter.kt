package com.pocodex.calendar

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.http.MediaType
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator
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