package com.example.xk.circleoffriends.entity;

import javax.persistence.Id;

public class PassageLike {
    @Id
    private Integer passageId;
    private String account;

    public Integer getPassageId() {
        return passageId;
    }

    public void setPassageId(Integer passageId) {
        this.passageId = passageId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }
}
