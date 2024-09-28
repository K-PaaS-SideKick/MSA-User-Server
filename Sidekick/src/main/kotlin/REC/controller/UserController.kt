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
}