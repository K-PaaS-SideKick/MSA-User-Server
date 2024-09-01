package REC.controller.request

import java.util.*

data class CreateUserRequest(
    val userName: String,
    val password: String,
    val email: String,
    val nickname: String,
    )