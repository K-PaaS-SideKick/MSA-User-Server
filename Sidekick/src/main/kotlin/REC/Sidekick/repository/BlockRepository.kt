package REC.Sidekick.repository

import REC.Sidekick.entity.Block
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BlockRepository : JpaRepository<Block, Long> {
    fun findAllByBlockId(blockId: String): List<Block>
}