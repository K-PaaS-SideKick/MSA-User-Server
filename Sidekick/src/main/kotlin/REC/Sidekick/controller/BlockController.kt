package REC.Sidekick.controller

import REC.Sidekick.controller.request.BlockRequest
import REC.Sidekick.controller.request.GetBlockRequest
import REC.Sidekick.controller.request.UnblockRequest
import REC.Sidekick.controller.response.BlockResponse
import REC.Sidekick.controller.response.GetBlockResponse
import REC.Sidekick.controller.response.UnblockResponse
import REC.Sidekick.service.BlockService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class BlockController (
    private val blockService: BlockService
){
    //Block
    @PostMapping("/block/{nickname}")
    fun blcokUser(@PathVariable nickname: String, @RequestBody blockRequest: BlockRequest): BlockResponse {
        return blockService.blockUser(blockRequest)
    }

    //UnBlock
    @DeleteMapping("/unblock/{nickname}")
    fun unblockUser(@PathVariable nickname: String, @RequestBody unblockRequest: UnblockRequest) : UnblockResponse {
        return blockService.unblockUser(unblockRequest)
    }

    //GetBlocks
    @PostMapping("/get/{nickname}")
    fun getBlockUser(@PathVariable nickname: String, @RequestBody getBlockRequest: GetBlockRequest) : GetBlockResponse {
        return blockService.getBlocks(getBlockRequest)
    }


}