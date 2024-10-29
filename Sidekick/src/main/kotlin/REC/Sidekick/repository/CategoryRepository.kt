package REC.Sidekick.repository

import REC.Sidekick.entity.Category
import org.springframework.data.jpa.repository.JpaRepository

interface CategoryRepository : JpaRepository<Category, Int>{
}