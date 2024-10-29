package REC.Sidekick.service

import REC.Sidekick.controller.request.CreateUrlRequest
import REC.Sidekick.controller.request.DeleteUrlRequest
import REC.Sidekick.controller.request.GetCvRequest
import REC.Sidekick.controller.request.UpdateUrlRequest
import REC.Sidekick.controller.response.CreateUrlResponse
import REC.Sidekick.controller.response.DeleteUrlResponse
import REC.Sidekick.controller.response.GetCvResponse
import REC.Sidekick.controller.response.UpdateUrlResponse
import REC.Sidekick.entity.Cv
import REC.Sidekick.repository.CvRepository
import org.springframework.stereotype.Service

@Service
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
        return CreateUrlResponse(cv.cvId)
    }

    fun updateUrl(updateUrlRequest: UpdateUrlRequest) : UpdateUrlResponse {
        val oldCv : Cv = cvRepository.findByCvId(updateUrlRequest.cvid)

        val newCv = Cv(
            oldCv.cvId,
            oldCv.userId,
            updateUrlRequest.url,
        )

        return UpdateUrlResponse(
            newCv.cvId
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