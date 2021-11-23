package com.example.repository

import com.example.domain.User
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.repository.CrudRepository
import io.micronaut.data.model.query.builder.sql.Dialect;


@Repository
@JdbcRepository(dialect= Dialect.POSTGRES)
interface UserRepository: CrudRepository<User, Long> {

    fun findByEmail(email: String): User?


}