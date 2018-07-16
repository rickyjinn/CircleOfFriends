package com.example.xk.circleoffriends.entity;

import javax.persistence.Id;

public class FriendRelationship {
    @Id //两个作为联合主键
    private String account;
    @Id
    private String friendAccount;

    public FriendRelationship(String account, String friendAccount) {
        this.account = account;
        this.friendAccount = friendAccount;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getFriendAccount() {
        return friendAccount;
    }

    public void setFriendAccount(String friendAccount) {
        this.friendAccount = friendAccount;
    }
}
