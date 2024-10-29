package REC.Sidekick.entity

import REC.util.EpochTimeUtil.getCurrentEpochTime
import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import jakarta.persistence.MappedSuperclass
import jakarta.persistence.PrePersist
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class BaseTimeEntity (
    @CreatedDate
    @field:Column(name = "created_at")
    var createdAt: Long? = null,

    @LastModifiedDate
    @field:Column(name = "updated_at")
    var updatedAt: Long? = null
){
    @PrePersist
    fun onCreate() {
        createdAt = getCurrentEpochTime()
    }

    fun onUpdate() {
        updatedAt = getCurrentEpochTime()
    }
}