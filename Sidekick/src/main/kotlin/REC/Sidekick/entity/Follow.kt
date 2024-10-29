package REC.Sidekick.entity

import jakarta.persistence.*

@Entity(name = "follow")
class Follow (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val fid : Long,

    @Column(name = "follow_id")
    val followId : String,

    @Column(name = "fellow_id")
    val fellowId : String
) : BaseTimeEntity() {
}