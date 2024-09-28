package REC.service

import REC.controller.request.*
import REC.controller.request.DeleteUrlRequest
import REC.controller.response.*
import REC.entity.Block
import REC.entity.User
import REC.repository.UserRepository
import java.util.*
import org.springframework.stereotype.Service

@Service
class UserService (
    private val userRepository: UserRepository
){
    fun createUser(createUserRequest: CreateUserRequest) : CreateUserResponse {
        val userInfo = User(
            UUID.randomUUID().toString(),
            createUserRequest.userId,
            createUserRequest.userName,
            createUserRequest.password,
            createUserRequest.email,
            createUserRequest.nickname,
            true,
        )

        userRepository.save(userInfo)

        return CreateUserResponse(userInfo.uid)
    }

    fun getUser(getUserRequest : GetUserRequest) : GetUserResponse {
        val userInfo = userRepository.findByUserId(getUserRequest.uid)
        return GetUserResponse (
            userInfo.uid,
            userInfo.userId,
            userInfo.userName,
            userInfo.password,
            userInfo.email,
            userInfo.nickname,
        )
    }

    fun updateUser(updateUserRequest: UpdateUserRequest) : UpdateUserResponse {
        val oldUserInfo = userRepository.findByUserId(updateUserRequest.uid)

        val newUserInfo = User(
            oldUserInfo.uid,
            updateUserRequest.userId,
            updateUserRequest.userName,
            updateUserRequest.password,
            updateUserRequest.email,
            updateUserRequest.nickname,
            true,
        )

        userRepository.save(newUserInfo)

        return UpdateUserResponse(newUserInfo.uid)
    }

    fun deleteUser(deleteUserRequest: DeleteUserRequest) : DeleteUserResponse {
        val result = userRepository.deleteById(deleteUserRequest.uid)
        return DeleteUserResponse(
            "Success"
        )
    }

}