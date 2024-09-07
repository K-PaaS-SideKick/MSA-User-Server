package REC.repository

import REC.controller.request.LoginRequest
import REC.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>{
    fun findByUserId(loginRequest: LoginRequest) {

    }
}