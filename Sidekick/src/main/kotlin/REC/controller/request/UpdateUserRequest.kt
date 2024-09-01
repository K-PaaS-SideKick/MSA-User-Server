package REC.controller.request

import java.util.UUID

data class UpdateUserRequest(
    val userId: UUID,
    val userName: String,
    val password: String,
    val email: String,
    val nickname: String,
)
