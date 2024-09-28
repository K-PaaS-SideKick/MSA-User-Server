package REC.controller

import REC.controller.request.CreateUrlRequest
import REC.controller.request.DeleteUrlRequest
import REC.controller.request.UpdateUrlRequest
import REC.controller.response.CreateUrlResponse
import REC.controller.response.DeleteUrlResponse
import REC.controller.response.UpdateUrlResponse
import REC.service.CvService
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class CvController (
    private val cvService: CvService
){
    //CreateUrl
    @PostMapping("/{nickname}/create-url}")
    fun createUrl(@PathVariable nickname : String, @RequestBody createUrlRequest : CreateUrlRequest) : CreateUrlResponse {
        return cvService.createUrl(createUrlRequest)
    }

    //UpdateUrl
    @PostMapping("/{nickname}/update-url")
    fun updateUrl(@PathVariable nickname: String, @RequestBody updateUrlRequest : UpdateUrlRequest) : UpdateUrlResponse {
        return cvService.updateUrl(updateUrlRequest)
    }

    //DeleteUrl
    @PostMapping("/{nickname}/delete-url")
    fun updateUrl(@PathVariable nickname: String, @RequestBody deleteUrlRequest: DeleteUrlRequest) : DeleteUrlResponse {
        return cvService.deleteUrl(deleteUrlRequest)
    }


}