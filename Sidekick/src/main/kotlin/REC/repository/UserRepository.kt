package REC.repository

import REC.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, String>{
    fun findByUserId(userId : String) : User {
        return findById(userId).orElseThrow { Exception("Party not found with id $userId") }
    }
}