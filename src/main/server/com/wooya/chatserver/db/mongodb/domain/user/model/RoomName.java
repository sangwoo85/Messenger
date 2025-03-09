package com.wooya.chatserver.db.mongodb.domain.user.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @title 채팅방과 채팅방 custom 이름을 매핑 한다.
 * */
@Getter
@Setter
@Document( collection = "roomName")
public class RoomName {

    //채팅방 ID
    String roomId;
    //채팅방 설정자 ID
    String userId;
    //Custom한 채팅방 이름
    String name;
    //생성 날짜
    Date createDate;
}
