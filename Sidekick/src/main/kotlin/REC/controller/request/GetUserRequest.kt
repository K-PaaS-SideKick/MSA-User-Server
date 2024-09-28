package REC.controller.request

data class GetUserRequest(
    val uid: String,
    val userId: String,
    val userName: String,
    val password: String,
    val email: String,
    val nickname: String,
)
