package REC.Sidekick.entity

import jakarta.persistence.*

@Entity(name = "cv")
class Cv (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv-id")
    val cvId: Long,

    @Column(name = "user_id")
    val userId : String,

    @Column(name = "url")
    val url : String,
) : BaseTimeEntity() {}