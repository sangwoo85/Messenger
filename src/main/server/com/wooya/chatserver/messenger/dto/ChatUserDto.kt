package com.wooya.chatserver.messenger.dto

data class ChatUserDto(
    val userId : String,
    val userName : String,
    val roomId : String, // 현재 사용자와의 대화방 RoomId
    val comment : String,//이 User의 Comment
    val profileImg : String, // 이 User의 이미지
)
