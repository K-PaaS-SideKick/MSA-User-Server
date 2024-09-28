package REC.repository

import REC.entity.Cv
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BioRepository : JpaRepository<Cv, Long> {
}