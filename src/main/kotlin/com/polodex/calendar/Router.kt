package com.polodex.calendar

import com.polodex.calendar.calendar.CalendarController
import com.polodex.calendar.timeslot.TimeSlotController
import com.polodex.calendar.user.UsersController
import org.springdoc.core.annotations.RouterOperation
import org.springdoc.core.annotations.RouterOperations
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.RequestPredicates.*
import org.springframework.web.reactive.function.server.RouterFunctions

@Configuration(proxyBeanMethods = false)
class Router {

    @Bean
    @RouterOperations(RouterOperation(path = "/calendars", beanClass = CalendarController::class, beanMethod = "getCalendarById", produces = arrayOf("APPLICATION_JSON")))
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
    @RouterOperation(path = "/users", beanClass = UsersController::class, beanMethod = "addUser")
    fun userRoute(usersController: UsersController) = RouterFunctions
        .route(
            POST("/users")
                .and(accept(MediaType.APPLICATION_JSON)),
            usersController::addUser
        )

    @Bean
    @RouterOperation(path = "/timeslots", beanClass = TimeSlotController::class, beanMethod = "createTimeSlot")
    fun timeSlotRoute(timeSlotController: TimeSlotController) = RouterFunctions
        .route(
            POST("/timeslots")
                .and(accept(MediaType.APPLICATION_JSON)),
            timeSlotController::createTimeSlot
        ).andRoute(
            GET("/timeslots")
                .and(accept(MediaType.APPLICATION_JSON))
                .and(queryParam("calendarId") { true }),
            timeSlotController::getTimeSlotsByCalendarId
        )
}