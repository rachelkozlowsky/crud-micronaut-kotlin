package com.example.services

import com.example.domain.User
import com.example.model.Response
import com.example.model.UserDTO

interface UserService {

    fun saveUser(user: User, response: Response<UserDTO>)

    fun delete(userId: Long, response: Response<UserDTO>)

    fun findAll(response: Response<List<UserDTO>>)

    fun findById(userId: Long, response: Response<UserDTO>)

}