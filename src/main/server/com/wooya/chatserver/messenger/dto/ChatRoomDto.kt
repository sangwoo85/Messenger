package com.wooya.chatserver.messenger.dto

import java.util.Date

/**
 * @title 채팅방 정보 Api 에서 사용할 DTO
 * */
data class ChatRoomDto(

    //채팅방 고유 ID
    val roomId : String,
    //마지막 메시지ID
    val lastMessageId : String,
    //생성 날짜
    val createDate : Date,
    //대화방 참가자 ID 과연 이게 맞을까? 1:1 채팅방 단체 채팅방... 아니면 단체  채팅방은 유형을 변경 해야 할까?
    // 채팅방 타입을 만들까?
    val participants : List<String>,
)


/*
*
*
*
*
*
*
*
*
* */