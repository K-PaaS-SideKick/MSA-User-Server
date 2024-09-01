package REC.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "category")
class Category (
    @Id
    @Column(name = "category")
    val category_id : Int,

    @Column(name = "name")
    val category_name : String,
){
}