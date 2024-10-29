package REC.Sidekick.controller.response

import REC.Sidekick.entity.Follow

data class GetFollowResponse(
    val userId : String,
    val follow : List<Follow>
)
