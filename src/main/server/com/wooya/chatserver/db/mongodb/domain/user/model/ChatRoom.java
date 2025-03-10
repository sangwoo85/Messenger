package com.wooya.chatserver.db.mongodb.domain.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Builder
@Setter
@Getter
@Document(collection = "ChatRoom")
public class ChatRoom {

    //RoomId
    public String roomId;
    //마지막 전송한 ID .. ID 아이디 기준으로  뭘할까?local Storage와 비교해서 이후  메시지만 가져 오던지 해야함....
    public String lastMessageId;
    //참가자들 ID
    public List<String> participants;
    //생성 날짜
    public Date createDate;
}

/**
 * 개인 채팅... 단체 채팅을
 *
 * 아니면 Room 안에 누가 있는지 알아야 하는데...  채팅방의 사람수가 정해지지 않았다.
 * 그렇군... 아 오케
 * userList 를 가져 올때.. 그럼  ChatRoomId를 가져 오면 되지 않을까?
 *
 * */