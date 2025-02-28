package com.wooya.chatserver.messenger.api

import com.wooya.chatserver.db.mongodb.domain.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Title
 * */
@RestController
class MessengerApiController(private val userService: UserService) {

    private val LOGGER = LoggerFactory.getLogger(this::class.java);

    @GetMapping("/saveUser")
    fun saveUser() : String{
        //userInfoService.createUserInfo(UserInfo("ksswy1","ss","ss","ss"))
        return "ddd"
    }

}