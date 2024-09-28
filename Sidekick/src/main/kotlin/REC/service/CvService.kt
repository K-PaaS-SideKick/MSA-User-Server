package REC.service

import REC.controller.request.CreateUrlRequest
import REC.controller.request.DeleteUrlRequest
import REC.controller.request.GetCvRequest
import REC.controller.request.UpdateUrlRequest
import REC.controller.response.CreateUrlResponse
import REC.controller.response.DeleteUrlResponse
import REC.controller.response.GetCvResponse
import REC.controller.response.UpdateUrlResponse
import REC.entity.Cv
import REC.repository.CvRepository

class CvService (
    private val cvRepository: CvRepository
){
    fun createUrl(createUrlRequest: CreateUrlRequest) : CreateUrlResponse {
        val cv = Cv(
            0,
            createUrlRequest.uid,
            createUrlRequest.url,
        )

        cvRepository.save(cv)
        return CreateUrlResponse(cv.cvid)
    }

    fun updateUrl(updateUrlRequest: UpdateUrlRequest) : UpdateUrlResponse {
        val oldCv : Cv = cvRepository.findByCvId(updateUrlRequest.cvid)

        val newCv = Cv(
            oldCv.cvid,
            oldCv.userId,
            updateUrlRequest.url,
        )

        return UpdateUrlResponse(
            newCv.cvid
        )
    }

    fun deleteUrl(deleteUrlRequest: DeleteUrlRequest) : DeleteUrlResponse {
        cvRepository.deleteById(deleteUrlRequest.cvid)

        return DeleteUrlResponse(
            "ok"
        )
    }

    fun getUrls(getCvRequest: GetCvRequest) : GetCvResponse {
        return GetCvResponse(
            getCvRequest.userId,
            cvRepository.findAllByUserId(getCvRequest.userId)
        )
    }
}