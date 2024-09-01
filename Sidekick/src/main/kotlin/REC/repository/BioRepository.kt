package REC.repository

import REC.entity.Bio
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BioRepository : JpaRepository<Bio, Long> {
}