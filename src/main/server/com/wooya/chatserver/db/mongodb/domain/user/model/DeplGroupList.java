package com.wooya.chatserver.db.mongodb.domain.user.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DeplGroupList {

    private String _id;
    private String deptName;
    private List<User> memberList;

}
