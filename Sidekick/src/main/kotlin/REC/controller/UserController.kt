package REC.controller

import REC.controller.request.*
import REC.controller.request.DeleteUrlRequest
import REC.controller.response.*
import REC.service.UserService
import jakarta.validation.Valid
import jakarta.ws.rs.Path
import org.hibernate.sql.Delete
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController("/user")
class UserController(
    private val userService: UserService
) {
    //createUser
    @PostMapping("/register/{nickname}")
    fun createUser(@PathVariable nickname : String, @Valid @RequestBody createUserRequest: CreateUserRequest): CreateUserResponse {
        return userService.createUser(createUserRequest)
    }

    //GetUser
    @PostMapping("/get/{nickname}")
    fun getUser(@PathVariable nickname: String, @RequestBody getUserRequest : GetUserRequest) : GetUserResponse {
        return userService.getUser(getUserRequest)
    }

    //updateUser
    @PostMapping("/update/{nickname}")
    fun updateUser(@PathVariable nickname : String, @Valid @RequestBody updateUserRequest: UpdateUserRequest): UpdateUserResponse {
        return userService.updateUser(updateUserRequest)
    }

    //deleteUser
    @DeleteMapping("/delete/{nickname}")
    fun deleteUser(@PathVariable nickname: String, @Valid @RequestBody deleteUserRequest: DeleteUserRequest) {
        userService.deleteUser(deleteUserRequest)
    }

    //Follow
    @PostMapping("/follow/{nickname}")
    fun followUser(@PathVariable nickname: String, @RequestBody followRequest: FollowRequest): FollowResponse {
        return userService.followUser(followRequest)
    }

    //UnFollow
    @DeleteMapping("/unfollow/{nickname}")
    fun unfollowUser(@PathVariable nickname: String, @RequestBody unfollowRequest: UnfollowRequest) : UnfollowResponse{
        return userService.unfollowUser(unfollowRequest)
    }

    //Block
    @PostMapping("/block/{nickname}")
    fun blcokUser(@PathVariable nickname: String, @RequestBody blockRequest: BlockRequest): BlockResponse {
        return userService.blockUser(blockRequest)
    }
    //UnBlock
    @DeleteMapping("/unblock/{nickname}")
    fun unblockUser(@PathVariable nickname: String, @RequestBody unblockRequest: UnblockRequest) : UnblockResponse{
        return userService.unblockUser(unblockRequest)
    }

    //CreateUrl
    @PostMapping("/{nickname}/create-url}")
    fun createUrl(@PathVariable nickname : String, @RequestBody createUrlRequest : CreateUrlRequest) : CreateUrlResponse{
        return userService.createUrl(createUrlRequest)
    }

    //UpdateUrl
    @PostMapping("/{nickname}/update-url")
    fun updateUrl(@PathVariable nickname: String, @RequestBody updateUrlRequest : UpdateUrlRequest) : UpdateUrlResponse{
        return userService.updateUrl(updateUrlRequest)
    }

    //DeleteUrl
    @PostMapping("/{nickname}/delete-url")
    fun updateUrl(@PathVariable nickname: String, @RequestBody deleteUrlRequest: DeleteUrlRequest) : DeleteUrlResponse{
        return userService.deleteUrl(deleteUrlRequest)
    }


}