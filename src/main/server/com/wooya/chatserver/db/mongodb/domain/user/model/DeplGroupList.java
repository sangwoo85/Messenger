package com.wooya.chatserver.db.mongodb.domain.user.model;


import java.util.List;

public class DeplGroupList {

    public String _id;
    public String deptName;
    public List<User> memberList;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<User> memberList) {
        this.memberList = memberList;
    }
}
