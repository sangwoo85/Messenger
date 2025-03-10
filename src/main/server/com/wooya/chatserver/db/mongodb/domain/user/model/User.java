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
    public String id;
    public String userId;
    public String name;
    public String dept;
    public String position;
    public String password;
    public String comment;
    public String profileImg;

}



