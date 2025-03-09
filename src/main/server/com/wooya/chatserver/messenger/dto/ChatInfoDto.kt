package com.wooya.chatserver.messenger.dto

data class ChatInfoDto(

    val userGrouList : List<UserGroup>,

    val chatRoomList : List<ChatRoomDto>
)
