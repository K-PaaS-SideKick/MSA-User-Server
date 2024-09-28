package REC.controller.request

data class UpdateUrlRequest(
    val cvid : Long,
    val userId : String,
    val url : String,
)
