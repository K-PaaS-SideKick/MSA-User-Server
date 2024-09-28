package REC.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import java.sql.Timestamp
import java.util.UUID

@Entity(name = "user")
class User (
    @Id
    @Column(name = "user-id")
    val uId : String,

    @Column(name = "Id")
    val userId : String,

    @Column(name = "name")
    val userName : String,

    @Column(name = "password")
    val password : String,

    @Column(name = "email")
    val email : String,

    @Column(name = "nickname")
    val nickname : String,

    @Column(name = "state")
    val state : Boolean,
) : BaseTimeEntity() {
}