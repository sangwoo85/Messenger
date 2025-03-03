package com.wooya.chatserver.messenger.api

import com.wooya.chatserver.db.mongodb.domain.service.UserService
import com.wooya.chatserver.db.mongodb.domain.user.model.DeplGroupList
import com.wooya.chatserver.db.mongodb.domain.user.model.User
import jakarta.servlet.http.HttpServletRequest
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

/**
 * @title 사용자 관련 Data를 select or insert 시 사용될 API
 * User 관련만 넣어 놓는다.
 * */
@RestController
class UserApiController(private val userService: UserService) {

    private val LOGGER = LoggerFactory.getLogger(this.javaClass);

    /*
    * @title 등록되어있는 사용자의 목록을 반환 해 준다.
    *
    * 2025.02.28 현재 기준으로는 전체 사용자 목록을 반환 해 주는데  추후에는 해당 사용자에게 등록 되어있는 사용자들만 반환 해주도록 변경 해 주면 좋을듯
    * */
    @PostMapping("/getUserList")
    fun getMyUserList():List<DeplGroupList>{
        LOGGER.info("START ")
         val userList = userService.groupByDeplList()
        LOGGER.info("user List [ {} ]",userList.toList().toString())
        return userList;
    }
}