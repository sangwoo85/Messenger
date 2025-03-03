package com.wooya.chatserver.db.mongodb.domain.user.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "User")
public class User {

    @Id
    String id;
    String userId;
    String name;
    String dept;
    String position;
    String password;
    String comment;
    String profileImg;

}



