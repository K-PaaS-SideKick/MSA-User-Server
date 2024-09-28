package REC.repository

import REC.entity.Cv
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CvRepository : JpaRepository<Cv, Long> {
    fun findByCvId(cvid: Long): Cv {
        return findById(cvid).orElseThrow { Exception("Party not found with id $cvid") }
    }

    fun findAllByUserId(userId: String): List<Cv>

}