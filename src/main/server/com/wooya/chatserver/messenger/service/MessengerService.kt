package com.wooya.chatserver.messenger.service

import com.wooya.chatserver.messenger.dto.ChatMessage
import com.wooya.chatserver.messenger.dto.ChatRoomDto

interface MessengerService {

    fun getUserClickChatRoom(chatRoom : ChatRoomDto):List<ChatMessage>?
}