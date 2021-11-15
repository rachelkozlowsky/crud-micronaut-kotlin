package com.example.controlls

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/")
class IndexControll {

    @Get
    fun index(): String {
        return "Hello World"
    }
}
