package REC.service

import REC.controller.request.LoginRequest
import REC.controller.request.RegisterRequest
import REC.controller.request.UpdateUserRequest
import REC.controller.response.LoginResponse
import REC.controller.response.RegisterResponse
import REC.entity.User
import REC.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService (
    private val userRepository: UserRepository
){
    fun registerUser(registerRequest: RegisterRequest) : RegisterResponse {
        val res =
            userRepository.save(
                User(
                    registerRequest.userId,
                    registerRequest.userName,
                    registerRequest.password,
                    registerRequest.email,
                    registerRequest.nickname,
                    ""
                )
            )

        return RegisterResponse(res.userName)
    }

    fun login(loginRequest: LoginRequest) : LoginResponse {
        val user = userRepository.findByUserId(loginRequest.userId) ?: throw IllegalArgumentException("UserNotFound")
    }

    fun updateUser(updateUserRequest: UpdateUserRequest) {

    }
}