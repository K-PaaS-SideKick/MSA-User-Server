package REC.service

import REC.controller.request.BlockRequest
import REC.controller.response.BlockResponse
import REC.entity.Block
import REC.repository.BlockRepository
import org.springframework.stereotype.Service

@Service
class BlockService (
    private val blockRepository: BlockRepository
){
    fun blockUser(blockRequest: BlockRequest) : BlockResponse {
        blockRepository.save(
            Block(
                0,
                blockRequest.blockId,
                blockRequest.blockedId,
            )
        )
        return BlockResponse(

        )
    }
}