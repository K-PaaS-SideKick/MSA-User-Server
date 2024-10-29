package REC.Sidekick.controller.request

import java.util.UUID

data class UpdateUserRequest(
    val uid: String,
    val userId:String,
    val userName: String,
    val password: String,
    val email: String,
    val nickname: String,
)
