package REC.controller.response

import REC.entity.Cv

data class GetCvResponse(
    val userId : String,
    val urlList : List<Cv>
)
