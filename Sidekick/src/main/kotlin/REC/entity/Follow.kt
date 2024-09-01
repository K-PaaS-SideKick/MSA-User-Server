package REC.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "follow")
class Follow (
    @Id
    @Column(name = "follow_id")
    val follow_id : Long,

    @Column(name = "fellow_id")
    val fellow_id : Long
) : BaseTimeEntity() {
}