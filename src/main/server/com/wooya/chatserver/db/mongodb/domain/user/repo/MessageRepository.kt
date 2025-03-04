package com.wooya.chatserver.db.mongodb.domain.user.repo

import com.wooya.chatserver.db.mongodb.domain.user.model.MessageInfo
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageRepository :MongoRepository<MessageInfo,String> {

    fun save(messageInfo: MessageInfo) :MessageInfo

    fun findByRoomId(roomId : String ) :List<MessageInfo>
}