package REC.service

import REC.controller.request.FollowRequest
import REC.controller.request.GetFollowRequest
import REC.controller.request.UnfollowRequest
import REC.controller.response.FollowResponse
import REC.controller.response.GetFollowResponse
import REC.controller.response.UnfollowResponse
import REC.entity.Follow
import REC.repository.FollowRepository

class FollowService (
    private val followRepository: FollowRepository
){
    fun followUser(followRequest: FollowRequest) : FollowResponse {
        val follow = Follow(
            0,
            followRequest.followId,
            followRequest.fellowId
        )

        followRepository.save(follow)
        return FollowResponse(follow.fid)
    }

    fun unfollowUser(unfollowRequest: UnfollowRequest) : UnfollowResponse {
        followRepository.deleteById(unfollowRequest.fid)
        return UnfollowResponse(
            "ok"
        )
    }

    fun getFollows(getFollowRequest: GetFollowRequest) : GetFollowResponse {
        return GetFollowResponse(
            getFollowRequest.userId,
            followRepository.findAllByFollowId(getFollowRequest.userId)
        )
    }
}