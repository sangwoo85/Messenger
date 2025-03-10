package com.wooya.chatserver.db.mongodb.domain.user.repo

import com.wooya.chatserver.db.mongodb.domain.user.model.ChatRoom
import org.springframework.data.mongodb.repository.MongoRepository

interface ChatRoomRepository : MongoRepository<ChatRoom, Long> {

    fun findByRoomId(chatRoomId: String): ChatRoom?

    fun findByParticipants(participants: List<String>): ChatRoom

    fun findByParticipants(participants: String): List<ChatRoom>
}