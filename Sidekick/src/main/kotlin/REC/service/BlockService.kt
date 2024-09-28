package REC.service

import REC.controller.request.BlockRequest
import REC.controller.request.GetBlockRequest
import REC.controller.request.UnblockRequest
import REC.controller.response.BlockResponse
import REC.controller.response.GetBlockResponse
import REC.controller.response.UnblockResponse
import REC.entity.Block
import REC.repository.BlockRepository
import org.springframework.stereotype.Service

@Service
class BlockService (
    private val blockRepository: BlockRepository
){
    fun blockUser(blockRequest: BlockRequest) : BlockResponse {
        val block = Block(
            0,
            blockRequest.blockId,
            blockRequest.blockedId,
        )

        blockRepository.save(block)
        return BlockResponse(block.bid)
    }

    fun unblockUser(unblockRequest: UnblockRequest) : UnblockResponse {
        blockRepository.deleteById(unblockRequest.bid)

        return UnblockResponse(
            "ok"
        )
    }

    fun getBlocks(getBlockRequest: GetBlockRequest) : GetBlockResponse {
        return GetBlockResponse(
            getBlockRequest.blockid,
            blockRepository.findAllByBlockId(getBlockRequest.blockid)
        )
    }

}