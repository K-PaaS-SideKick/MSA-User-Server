package REC.controller.response

import REC.entity.Block

data class GetBlockResponse(
    val blockid : String,
    val blockedList : List<Block>
)
