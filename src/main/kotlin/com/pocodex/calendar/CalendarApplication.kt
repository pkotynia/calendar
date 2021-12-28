package com.pocodex.calendar

import io.r2dbc.spi.ConnectionFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.core.io.ClassPathResource
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator

@SpringBootApplication()
class CalendarApplication

//Any organization that designs a system (defined broadly) will produce a design whose structure is a copy of the organization's communication structure.[2][3]
//
//Melvin E. Conway
@Bean
fun initializer(connectionFactory: ConnectionFactory?): ConnectionFactoryInitializer? {
    val initializer = ConnectionFactoryInitializer()
    initializer.setConnectionFactory(connectionFactory!!)
    initializer.setDatabasePopulator(ResourceDatabasePopulator(ClassPathResource("schema.sql")))
    return initializer
}

fun main(args: Array<String>) {
	runApplication<CalendarApplication>(*args)


}


