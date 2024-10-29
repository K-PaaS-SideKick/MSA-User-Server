package REC.Sidekick.controller.response

import REC.Sidekick.entity.Block

data class GetBlockResponse(
    val blockid : String,
    val blockedList : List<Block>
)
