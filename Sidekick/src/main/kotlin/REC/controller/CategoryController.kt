package REC.controller

import REC.controller.request.CreateCategoryRequest
import REC.controller.request.GetCategoryRequest
import REC.controller.response.CreateCategoryResponse
import REC.controller.response.GetCategoryResponse
import REC.repository.CategoryRepository
import jakarta.transaction.Transactional
import jakarta.validation.Valid
import REC.entity.Category
import org.springframework.web.bind.annotation.*
import kotlin.jvm.optionals.toList

@RestController("/tag")
class CategoryController (
    private val categoryRepository: CategoryRepository
){
    @GetMapping("get-categories")
    @Transactional
    fun getAllCategories() : GetCategoryResponse {
        val categories = categoryRepository.findAll()
        return GetCategoryResponse(categories)
    }

    @PostMapping("/create-category")
    @Transactional
    fun createCategory(
        @Valid @RequestBody createGetCategoryRequest: CreateCategoryRequest
    ) : CreateCategoryResponse{
        val category = Category(0, createGetCategoryRequest.name)
        val res = categoryRepository.save(category)

        return CreateCategoryResponse(res.categoryName)
    }

    @PostMapping("/delete-category/{categoryId}")
    @Transactional
    fun deleteCatgory( @Valid @PathVariable categoryId: Int) {
        return categoryRepository.deleteById(categoryId)
    }

    @PostMapping("/get-category")
    @Transactional
    fun getCategory( @Valid @RequestBody getCategoryRequest: GetCategoryRequest): GetCategoryResponse {
        return GetCategoryResponse(
            categoryRepository.findById(getCategoryRequest.categoryId).toList()
        )
    }
}