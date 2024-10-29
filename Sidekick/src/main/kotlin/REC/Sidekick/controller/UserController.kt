package REC.Sidekick.controller

import REC.Sidekick.controller.request.*
import REC.Sidekick.controller.response.CreateUserResponse
import REC.Sidekick.controller.response.GetUserResponse
import REC.Sidekick.controller.response.UpdateUserResponse
import REC.Sidekick.service.UserService
import jakarta.validation.Valid
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
}