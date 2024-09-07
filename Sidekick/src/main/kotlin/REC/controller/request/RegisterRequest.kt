package REC.controller.request

data class RegisterRequest(
    val userId : String,
    val userName: String,
    val password: String,
    val email: String,
    val nickname: String,
    )