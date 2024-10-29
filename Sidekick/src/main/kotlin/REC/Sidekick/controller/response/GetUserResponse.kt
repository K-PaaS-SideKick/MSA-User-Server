package REC.Sidekick.controller.response

data class GetUserResponse(
    val uid: String,
    val userId: String,
    val userName: String,
    val password: String,
    val email: String,
    val nickname: String,
)
