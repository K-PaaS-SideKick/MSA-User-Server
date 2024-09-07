package REC.controller

import REC.controller.request.LoginRequest
import REC.controller.request.RegisterRequest
import REC.controller.response.LoginResponse
import REC.controller.response.RegisterResponse
import REC.service.UserService
import jakarta.validation.Valid
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController("/user")
class UserController(
    private val userService: UserService
) {
    // Register
    @PostMapping("/register")
    fun registerUser(@Valid @RequestBody registerRequest: RegisterRequest): RegisterResponse {
        return userService.registerUser(registerRequest)
    }

    // Login
    @PostMapping("/login")
    fun login(@Valid @RequestBody loginRequest : LoginRequest): LoginResponse {
        val loginResponse = userService.login(loginRequest)

        return LoginResponse(loginResponse)
    }

    // MyProjects
    @GetMapping("/{userId}/projects")
    fun getMyProjects(@PathVariable userId: Long): ResponseEntity<List<ProjectDto>> {
        val projects = userService.getProjectsByUserId(userId)
        return ResponseEntity.ok(projects)
    }

    // MyPosts
    @GetMapping("/{userId}/posts")
    fun getMyPosts(@PathVariable userId: Long): ResponseEntity<List<PostDto>> {
        val posts = userService.getPostsByUserId(userId)
        return ResponseEntity.ok(posts)
    }

    // MyScraps
    @GetMapping("/{userId}/scraps")
    fun getMyScraps(@PathVariable userId: Long): ResponseEntity<List<PostDto>> {
        val scraps = userService.getScrapsByUserId(userId)
        return ResponseEntity.ok(scraps)
    }

    // MyLikes
    @GetMapping("/{userId}/likes")
    fun getMyLikes(@PathVariable userId: Long): ResponseEntity<List<PostDto>> {
        val likes = userService.getLikesByUserId(userId)
        return ResponseEntity.ok(likes)
    }

    // MyComments
    @GetMapping("/{userId}/comments")
    fun getMyComments(@PathVariable userId: Long): ResponseEntity<List<CommentDto>> {
        val comments = userService.getCommentsByUserId(userId)
        return ResponseEntity.ok(comments)
    }
}