package REC.Sidekick.repository

import REC.Sidekick.entity.Follow
import org.springframework.data.jpa.repository.JpaRepository

interface FollowRepository : JpaRepository<Follow, Long> {
    fun findAllByFollowId(userId: String): List<Follow>
}