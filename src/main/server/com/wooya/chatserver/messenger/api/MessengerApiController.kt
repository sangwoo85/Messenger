package com.wooya.chatserver.messenger.api

import com.wooya.chatserver.db.mongodb.domain.service.UserInfoService
import com.wooya.chatserver.db.mongodb.domain.user.model.UserInfo
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Title message 보내는 Controller
 * */
@RestController
class MessengerApiController(private val userInfoService: UserInfoService) {

    private val LOGGER = LoggerFactory.getLogger(this::class.java);

    @GetMapping("/getUserList")
    fun testUserInfo() : List<UserInfo> {
        LOGGER.info("START")
        val userList =  userInfoService.findAll()
        LOGGER.info(userList.toString());
        return userList
    }

    @GetMapping("/saveUser")
    fun saveUser() : String{
        //userInfoService.createUserInfo(UserInfo("ksswy1","ss","ss","ss"))
        return "ddd"
    }

}