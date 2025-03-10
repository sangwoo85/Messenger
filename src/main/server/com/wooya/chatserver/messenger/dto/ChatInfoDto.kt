package com.wooya.chatserver.messenger.dto

/**
 * 채팅 최초 접근 하였을때 가져오는 Data들의 집합
 *
 *
 * */
data class ChatInfoDto(

    val userGrouList : List<UserGroupDto>,

    val chatRoomList : List<ChatRoomDto>
)
