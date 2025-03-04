package com.wooya.chatserver.db.mongodb.domain.service

import com.wooya.chatserver.db.mongodb.domain.user.model.MessageInfo
import com.wooya.chatserver.db.mongodb.domain.user.repo.MessageRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class MessageService(private val repository: MessageRepository) {

    final val LOGGER = LoggerFactory.getLogger(this::class.java)

    fun saveMessage(message: MessageInfo): MessageInfo {
        LOGGER.info("START [ {} ]",message.toString())
        return repository.save(message)
    }

    fun  getChatListOfTheRoom(roomId:String) :List<MessageInfo>{
        LOGGER.info("START [ {} ]",roomId)
        return repository.findByRoomId(roomId);
    }
}