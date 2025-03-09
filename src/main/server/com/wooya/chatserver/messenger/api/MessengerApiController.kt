package com.wooya.chatserver.messenger.api

import com.wooya.chatserver.db.mongodb.domain.service.MessengerService
import com.wooya.chatserver.db.mongodb.domain.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

/**
 * @Title
 * */
@RestController
class MessengerApiController(private val userService: UserService
                            ,private val messengerService: MessengerService) {

    private val LOGGER = LoggerFactory.getLogger(this::class.java);

    @GetMapping("/saveUser")
    fun saveUser() : String{
        //userInfoService.createUserInfo(UserInfo("ksswy1","ss","ss","ss"))
        return "ddd"
    }

    @GetMapping("/getChatRoomList")
    fun getMyChatRoomList(){
        LOGGER.info("START");
    }

    /**
     * @title 현재 채팅방의 채팅 목록을 가져 온다.
     * */
    fun getChatList(){
        LOGGER.info("START");
    }

    @GetMapping("/getChatRoom/{chatRoomId}")
    fun getMessagesInChatRoomList(){

    }
}