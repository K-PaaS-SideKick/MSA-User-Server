package REC.Sidekick.service

import REC.Sidekick.controller.request.FollowRequest
import REC.Sidekick.controller.request.GetFollowRequest
import REC.Sidekick.controller.request.UnfollowRequest
import REC.Sidekick.controller.response.FollowResponse
import REC.Sidekick.controller.response.GetFollowResponse
import REC.Sidekick.controller.response.UnfollowResponse
import REC.Sidekick.entity.Follow
import REC.Sidekick.repository.FollowRepository

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