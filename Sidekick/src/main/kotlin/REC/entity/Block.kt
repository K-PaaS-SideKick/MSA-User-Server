package REC.entity

import jakarta.persistence.*

@Entity(name = "block")
class Block (
    @Id
    @Column(name = "bid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val bid : Long,

    @Column(name = "block")
    val blockId : String,

    @Column(name = "blocked")
    val blockedId : String,
) : BaseTimeEntity() {}