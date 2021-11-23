package com.example.domain

import javax.persistence.*


@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue
    var id: Long = 0,
    @Column(name = "name")
    var name: String = "",
    @Column(name = "password")
    var password: String = "",
    @Column(name = "email")
    var email: String = ""
)