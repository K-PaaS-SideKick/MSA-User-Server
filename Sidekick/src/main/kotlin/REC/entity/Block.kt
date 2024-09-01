package REC.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "block")
class Block (
    @Id
    @Column(name = "block")
    val block_id : Long,

    @Column(name = "blocked")
    val blocked_id : Long,
) : BaseTimeEntity() {}