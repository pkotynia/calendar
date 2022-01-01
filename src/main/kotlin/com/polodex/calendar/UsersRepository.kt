package com.polodex.calendar

import org.springframework.data.annotation.Id
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.data.relational.core.mapping.Table
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository: R2dbcRepository<User, String>

@Table("users")
data class User(@Id val id:Int?, val name: String)