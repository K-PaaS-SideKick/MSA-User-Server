package REC.Sidekick.service

import REC.Sidekick.controller.request.BlockRequest
import REC.Sidekick.controller.request.GetBlockRequest
import REC.Sidekick.controller.request.UnblockRequest
import REC.Sidekick.controller.response.BlockResponse
import REC.Sidekick.controller.response.GetBlockResponse
import REC.Sidekick.controller.response.UnblockResponse
import REC.Sidekick.entity.Block
import REC.Sidekick.repository.BlockRepository
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