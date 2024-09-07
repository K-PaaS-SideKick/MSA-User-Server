package REC.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.sql.Timestamp
import java.util.UUID

@Entity(name = "user")
class User (
    @Id
    @Column(name = "user_id")
    val userId : String,

    @Column(name = "name")
    val userName : String,

    @Column(name = "password")
    val password : String,

    @Column(name = "email")
    val email : String,

    @Column(name = "nickname")
    val nickname : String,

    @Column(name = "cv")
    val cv : String,
) : BaseTimeEntity() {
}