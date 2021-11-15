package com.example.services

import com.example.domain.User
import com.example.model.Response
import com.example.model.UserDTO
import com.example.repository.UserRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class UserServiceImplementacao : UserService {

    @Inject
    lateinit var userRepository: UserRepository

    override fun saveUser(user: User, response: Response<UserDTO>) {

        val tempUser = userRepository.findByEmail(user.email)

        if (tempUser != null){
            response.errors.add("Usuario ja Cadastrado!")
            return
        }

        userRepository.apply {
            save(user)
            findByEmail(user.email)?.let { response.response = UserDTO(it) }
        }
    }

    override fun delete(userId: Long, response: Response<UserDTO>) {
        userRepository.deleteById(userId)
    }

    override fun findAll(response: Response<List<UserDTO>>) {
        val userList = userRepository.findAll().map { UserDTO(it) }
        response.response = userList
    }

    override fun findById(userId: Long, response: Response<UserDTO>) {
        val user = userRepository.findById(userId)
        if (user.isPresent){
            response.response = UserDTO(user.get())
        }else{
            response.errors.add("Id invalido!")
        }
    }
}