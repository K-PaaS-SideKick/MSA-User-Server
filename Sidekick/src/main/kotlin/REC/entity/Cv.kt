package REC.entity

import jakarta.persistence.*

@Entity(name = "bio")
class Cv (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cv-id")
    val cvId: Long,

    @Column(name = "user_id")
    val userId : String,

    @Column(name = "link")
    val link : String,
){}