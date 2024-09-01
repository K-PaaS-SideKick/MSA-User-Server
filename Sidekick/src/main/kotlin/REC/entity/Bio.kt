package REC.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "bio")
class Bio (
    @Id
    @Column(name = "user_id")
    val user_id : Long,

    @Column(name = "link")
    val link : String,
){}