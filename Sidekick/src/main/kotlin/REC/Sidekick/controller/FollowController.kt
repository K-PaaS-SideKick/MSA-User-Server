package REC.Sidekick.controller

import REC.Sidekick.controller.request.FollowRequest
import REC.Sidekick.controller.request.GetFollowRequest
import REC.Sidekick.controller.request.UnfollowRequest
import REC.Sidekick.controller.response.FollowResponse
import REC.Sidekick.controller.response.GetFollowResponse
import REC.Sidekick.controller.response.UnfollowResponse
import REC.Sidekick.service.FollowService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

class FollowController (
    private val followService: FollowService,
){
    //Follow
    @PostMapping("/follow/{nickname}")
    fun followUser(@PathVariable nickname: String, @RequestBody followRequest: FollowRequest): FollowResponse {
        return followService.followUser(followRequest)
    }

    //UnFollow
    @DeleteMapping("/unfollow/{nickname}")
    fun unfollowUser(@PathVariable nickname: String, @RequestBody unfollowRequest: UnfollowRequest) : UnfollowResponse {
        return followService.unfollowUser(unfollowRequest)
    }

    //GetFollows
    @PostMapping("/getfollow/{nickname}")
    fun getFollows(@PathVariable nickname: String, @RequestBody getFollowRequest: GetFollowRequest) : GetFollowResponse {
        return followService.getFollows(getFollowRequest)
    }


}