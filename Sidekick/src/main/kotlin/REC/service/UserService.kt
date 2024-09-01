package REC.service

import REC.controller.request.CreateUserRequest
import REC.controller.request.UpdateUserRequest
import REC.entity.User
import REC.repository.UserRepository
import java.util.*
import kotlin.random.Random

class UserService (
    private val userRepository: UserRepository
){
    fun createUser(createUserRequest : CreateUserRequest) {
        val userId = UUID.randomUUID()
        val res =
            userRepository.save(
                User(
                    userId,
                    createUserRequest.userName,
                    createUserRequest.password,
                    createUserRequest.email,
                    createUserRequest.nickname,
                    ""
                )
            )
    }

    fun updateUser(updateUserRequest: UpdateUserRequest) {

    }
}