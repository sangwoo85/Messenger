package com.wooya.chatserver.db.mongodb.domain.user.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Position")
public class Position {

    String code;

    String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
