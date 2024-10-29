package REC.Sidekick.controller.response

import REC.Sidekick.entity.Cv

data class GetCvResponse(
    val userId : String,
    val urlList : List<Cv>
)
