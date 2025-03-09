package com.wooya.chatserver.messenger.dto

data class ChatMessage(
    val value: String ="", //메시지의  내용
    val sender: String ="", // 보내는 사람
    val date : String ="",  //  날짜 yyyy-mm-dd 24hi:mi:ss
    val type : String ="",  // 메시지 타입
    val chatId : String ="", // 메시지 보낼때 사용되는 임시 ID
    val roomId : String = "", // 보내는 채팅방의 고유 ID




)
