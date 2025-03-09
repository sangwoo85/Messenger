package com.wooya.chatserver.db.mongodb.domain.user.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Message")
public record MessageInfo(
    String value, // 내용
    String type,  // 메시지의 타입
    String sender, // 보낸 사람
    String sendId, // 메시지 보낼때 임시로 할당하는 ID
    String date, // message 보낸 시간 날짜
    String roomId, //방 고유 Id 단체 및 1:1
    String messageId // 메시지의 고유 ID
) {
}
