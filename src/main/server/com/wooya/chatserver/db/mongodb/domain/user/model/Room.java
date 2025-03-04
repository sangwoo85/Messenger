package com.wooya.chatserver.db.mongodb.domain.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Setter
@Getter
@Document(collection = "Room")
public class Room {

    String roomId;


}
