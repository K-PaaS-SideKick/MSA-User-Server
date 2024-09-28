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

        return CreateUserResponse(userInfo.uId)
    }

    fun getUser(getUserRequest : GetUserRequest) : GetUserResponse {
        return GetUserResponse (

        )
    }

    fun updateUser(updateUserRequest: UpdateUserRequest) : UpdateUserResponse {
        return UpdateUserResponse(

        )
    }

    fun deleteUser(deleteUserRequest: DeleteUserRequest) : DeleteUserResponse {
        return DeleteUserResponse(

        )
    }

    fun followUser(followRequest: FollowRequest) : FollowResponse {
        return FollowResponse(

        )
    }

    fun unfollowUser(unfollowRequest: UnfollowRequest) : UnfollowResponse {
        return UnfollowResponse(

        )
    }

    fun unblockUser(unblockRequest: UnblockRequest) : UnblockResponse {
        return UnblockResponse(

        )
    }

    fun createUrl(createUrlRequest: CreateUrlRequest) : CreateUrlResponse {
        return CreateUrlResponse(

        )
    }

    fun updateUrl(updateUrlRequest: UpdateUrlRequest) : UpdateUrlResponse {
        return UpdateUrlResponse(

        )
    }

    fun deleteUrl(deleteUrlRequest: DeleteUrlRequest) : DeleteUrlResponse {
        return DeleteUrlResponse(

        )
    }
}