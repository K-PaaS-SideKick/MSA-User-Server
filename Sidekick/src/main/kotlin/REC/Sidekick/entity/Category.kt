package REC.Sidekick.entity

import jakarta.persistence.*

@Entity(name = "category")
class Category (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category")
    val categoryId : Int,

    @Column(name = "name")
    val categoryName : String,
){
}