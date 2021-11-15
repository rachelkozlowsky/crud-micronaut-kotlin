package com.example.controlls

import com.example.model.Response
import com.example.model.UserDTO
import com.example.services.UserService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import jakarta.inject.Inject


@Controller("user")
class UserControll {

    @Inject
    lateinit var userService: UserService

    @Post
    fun save(@Body userDto: UserDTO): HttpResponse<Response<UserDTO>> {
        val response = Response<UserDTO>()
        val user = userDto.toUse()

        return if (user != null) {
            userService.saveUser(user, response)
            HttpResponse.ok()
        } else {
            response.errors.add("Usuario invalido!")
            HttpResponse.badRequest(response)
        }
    }

    @Get
    fun findAll(): HttpResponse<Response<List<UserDTO>>>{
        val response = Response<List<UserDTO>>()
        userService.findAll(response)
        return HttpResponse.ok(response)
    }

    @Delete("/{id}")
    fun delete(@Part id: Long): HttpResponse<Response<UserDTO>>{
        val response = Response<UserDTO>()
        userService.delete(id, response)
        return HttpResponse.ok(response)
    }

    @Get("/{id}")
    fun findById(@Part id: Long): HttpResponse<Response<UserDTO>>{
        val response = Response<UserDTO>()
        userService.findById(id, response)
        return HttpResponse.ok(response)
    }
}