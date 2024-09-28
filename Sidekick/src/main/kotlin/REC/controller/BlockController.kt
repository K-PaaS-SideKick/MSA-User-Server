package REC.controller

import REC.controller.request.BlockRequest
import REC.controller.request.GetBlockRequest
import REC.controller.request.UnblockRequest
import REC.controller.response.BlockResponse
import REC.controller.response.GetBlockResponse
import REC.controller.response.UnblockResponse
import REC.service.BlockService
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