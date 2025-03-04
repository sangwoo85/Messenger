package com.wooya.chatserver.messenger.api

import com.wooya.chatserver.messenger.dto.ChatMessage
import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import java.security.Principal

/**
 * @title 채팅 관련 메시지를 수신 하는 API contorller
 *
 *
 * */
@Controller
class MessageApiController(private val messageTemplate: SimpMessagingTemplate) {

    private final val LOGGER = LoggerFactory.getLogger(MessageApiController::class.java)

    /**
     * 1차  채팅방 마다 구독을 roomId로 구독 해서 채팅방의 사람들이 모두 구독하여 받을 수 있도록
     *
     * 2차
     *
     * */
    @MessageMapping("/private-message")
    fun sendPrivateMessage(message : ChatMessage, principal : Principal) {
        LOGGER.info("START");
        val roomId = message.roomId;
        val name = principal.name;
        LOGGER.info("sender $name to $roomId")
        messageTemplate.convertAndSend("/queue/room/$roomId",message)
    }




}