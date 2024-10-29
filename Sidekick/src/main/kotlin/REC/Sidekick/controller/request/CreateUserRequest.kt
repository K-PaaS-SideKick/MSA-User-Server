package REC.Sidekick.controller.request

data class CreateUserRequest(
    val userId : String,
    val userName: String,
    val password: String,
    val email: String,
    val nickname: String,
    )