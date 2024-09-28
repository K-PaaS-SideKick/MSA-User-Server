package REC.controller.response

import REC.entity.Follow

data class GetFollowResponse(
    val userId : String,
    val follow : List<Follow>
)
