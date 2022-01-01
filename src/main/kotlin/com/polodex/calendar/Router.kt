package com.polodex.calendar

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunctions

@Configuration(proxyBeanMethods = false)
class Router {

    @Bean
    fun calendarRoute(calendarController: CalendarController) = RouterFunctions
        .route(
            GET("/calendars")
                .and(accept(MediaType.APPLICATION_JSON))
                .and(queryParam("id") { true }),
            calendarController::getCalendarById
        ).andRoute(
            POST("/calendars")
                .and(accept(MediaType.APPLICATION_JSON)),
            calendarController::createEmptyCalendar
        )


    @Bean
    fun userRoute(usersController: UsersController) = RouterFunctions
        .route(
            POST("/users")
                .and(accept(MediaType.APPLICATION_JSON)),
            usersController::addUser
        )


}