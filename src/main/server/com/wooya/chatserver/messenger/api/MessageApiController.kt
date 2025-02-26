package com.wooya.chatserver.messenger.api

import com.wooya.chatserver.messenger.dto.ChatMessage
import org.slf4j.LoggerFactory
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller
import java.security.Principal

@Controller
class MessageApiController(private val messageTemplate: SimpMessagingTemplate) {

    private final val LOGGER = LoggerFactory.getLogger(MessageApiController::class.java)

    @MessageMapping("/private-message")
    fun sendPrivateMessage(message : ChatMessage, principal : Principal) {
        LOGGER.info("START");
        val receiver = message.receiver;
        val name = principal.name;
        LOGGER.info("sender $name to $receiver")
        messageTemplate.convertAndSend("/queue/messages/$receiver",message)
    }




}